function A = align(layers, numLayers, color, shift)
% shift = 20;
shift_i = 0;
shift_j = 0;
for ix=numLayers:-1:1
    pyramidLayer = layers{ix};
    layerB = pyramidLayer{1};
    layerG = pyramidLayer{2};
    layerR = pyramidLayer{3};
    tempImage = cat(3, layerB, layerG, layerR);
%    imshow(tempImage);
    if color == 'G'
        layerG = circshift(layerG, [shift_i, shift_j]);
        [shift_i, shift_j] = shiftPixels(layerB, layerG, shift);
    end;
    if color == 'R'
        layerR = circshift(layerR, [shift_i, shift_j]);
        [shift_i, shift_j] = shiftPixels(layerB, layerR, shift);
    end;
%     ix
%     shift_i
%     shift_j
end;

if color == 'G'
    A = circshift(layerG, [shift_i, shift_j]);
end;
if color == 'R'
    A = circshift(layerR, [shift_i, shift_j]);
end;
