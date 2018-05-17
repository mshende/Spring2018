function cropped_image = edge_detection(img, filt)

vertEdgeImage = imfilter(img, filt);
imageSize = size(img);
columnSums = sum(vertEdgeImage);
leftIndex = 0;
maxDifference = 0
leftIndex = 1
for ix=5:19
    difference = abs(columnSums(ix))-abs(columnSums(ix+1))
    if difference > maxDifference
        maxDifference = difference;
        leftIndex = ix+1;
    end;
end;

maxDifference = 0;
rightIndex = 1;
for ix = length(columnSums)-20:length(columnSums)-5
    difference = abs(columnSums(ix+1))-abs(columnSums(ix));
    if difference > maxDifference
        maxDifference = difference;
        rightIndex = ix;
    end;
end; 
maxDifference = 0;
newLeftIndex = 1;
for ix=leftIndex:leftIndex+20
    difference = abs(columnSums(ix+1))-abs(columnSums(ix));
    if difference > maxDifference
        maxDifference = difference;
        newLeftIndex = ix+1;
    end;
end;

leftIndex
rightIndex

maxDifference = 0;
newRightIndex = 1;
for ix=rightIndex-10:rightIndex-1
    difference = abs(columnSums(ix))-abs(columnSums(ix+1));
    if difference > maxDifference
        maxDifference = difference;
        newRightIndex = ix;
    end;
end;
cropped_image = img(:, newLeftIndex:newRightIndex);
