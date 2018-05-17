% CS194-26 (cs219-26): Project 1, starter Matlab code

% name of the input file
imname = 'data/data/00580r.jpg';

% read in the image
fullim = imread(imname);

% convert to double matrix (might want to do this later on to same memory)
fullim = im2double(fullim);

% compute the height of each part (just 1/3 of total)
height = floor(size(fullim,1)/3);
% separate color channels
B = fullim(1:height,:);
G = fullim(height+1:height*2,:);
R = fullim(height*2+1:height*3,:);

h = fspecial('prewitt');
v = h';

%detect edges in B, G and R
vertCroppedB = edge_detection(B,v);
horzCroppedB = edge_detection(vertCroppedB',h);
croppedB = horzCroppedB';
vertCroppedG = edge_detection(G,v);
horzCroppedG = edge_detection(vertCroppedG', h);
croppedG = horzCroppedG';
vertCroppedR = edge_detection(R,v);
horzCroppedR = edge_detection(vertCroppedR', h);
croppedR = horzCroppedR';

sizeB = size(croppedB);
sizeG = size(croppedG);
sizeR = size(croppedR);

minRows = min([sizeB(1) sizeG(1) sizeR(1)]);
minCols = min([sizeB(2) sizeG(2) sizeR(2)]);

bRowDiff = (sizeB(1) - minRows);
bColDiff = (sizeB(2) - minCols);
gRowDiff = (sizeG(1) - minRows);
gColDiff = (sizeG(2) - minCols);
rRowDiff = (sizeR(1) - minRows);
rColDiff = (sizeR(2) - minCols);

newCroppedB = croppedB(bRowDiff+1:end,bColDiff+1:end);
newCroppedG = croppedG(gRowDiff+1:end,gColDiff+1:end);
newCroppedR = croppedR(rRowDiff+1:end,rColDiff+1:end);

% blur the image using a gaussian filter
% create the pyramid with 'numLayers' number of layers
gaussB = imgaussfilt(newCroppedB,2);
gaussG = imgaussfilt(newCroppedG,2);
gaussR = imgaussfilt(newCroppedR,2);
gaussImage = cat(3, gaussB, gaussG, gaussR);
tempB = gaussB;
tempG = gaussG;
tempR = gaussR;
layers = {{newCroppedB, newCroppedG, newCroppedR}};
numLayers=6;
for ix=1:numLayers
    halfB = tempB(1:2:end, 1:2:end);
    halfG = tempG(1:2:end, 1:2:end);
    halfR = tempR(1:2:end, 1:2:end);
    tempB = halfB;
    tempG = halfG;
    tempR = halfR;
    layers{end+1} = {halfB, halfG, halfR};
end;

dim = size(layers{end}{1});
shift = dim(1)

% align each layer of the pyramid, starting 
% with the coarsest layer, aligning G to B 
% and R to B
A = align(layers, numLayers+1, 'G', shift);
aG = A;
A = align(layers, numLayers+1, 'R', shift);
aR = A;

shiftedImage = cat(3, newCroppedB,aG,aR);
originalImage = cat(3, B, G, R);
subplot(1,2,1)
imshow(originalImage)
title('Original Image');
subplot(1,2,2)
imshow(shiftedImage)
title('Shifted Image')

% sixthB = B(1:6:end, 1:6:end);
% sixthG = G(1:6:end, 1:6:end);
% sixthR = R(1:6:end, 1:6:end);
% sixthImage = cat(3, sixthB, sixthG, sixthR);

% Align the images
% Functions that might be useful to you for aligning the images include: 
% "circshift", "sum", and "imresize" (for multiscale)
  %%%%%aG = align(G,B);
%%%%%aR = align(R,B);


% open figure
%% figure(1);

% create a color image (3D array)
% ... use the "cat" command
% show the resulting image
% ... use the "imshow" command
% save result image
%% imwrite(colorim,['result-' imname]);
