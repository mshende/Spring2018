function A = maya_align(im1, im2)

gaussIm1 = imgaussfilt(im1,2);
gaussIm2 = imgaussfilt(im2,2);
tempIm1 = gaussIm1;
tempIm2 = gaussIm2;
layers = {{im1, im2}};
num_layers = 5;
for ix=1:num_layers
    halfIm1 = tempIm1(1:2:end, 1:2:end);
    halfIm2 = tempIm2(1:2:end, 1:2:end);
    tempIm1 = halfIm1;
    tempIm2 = halfIm2;
    layers{end+1} = {halfIm1, halfIm2};
end;

dim = size(layers{end}{1});
shift = dim(1);

shift_i = 0;
shift_j = 0;
for ix=num_layers:-1:1
    pyramidLayer = layers{ix};
    layerIm1 = pyramidLayer{1};
    layerIm2 = pyramidLayer{2};
%    imshow(tempImage);
    layerIm1 = circshift(layerIm1, [shift_i, shift_j]);
    [shift_i, shift_j] = shiftPixels(layerIm2, layerIm1, shift);
end;

A = circshift(layerIm1, [shift_i, shift_j]);

