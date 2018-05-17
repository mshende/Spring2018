A = imread('Depth-Map-Stereo-teapot.png');
imagesc(A);

sizeA = size(A);
numRows = sizeA(1);
numCols = sizeA(2);
randomColor = [102 34 190];
A(5,1,:)
for ix=1:numRows
    ix;
    newColor = false;
    %row = A(ix,:,:);
    kx = 1;
    coloredArray = zeros(1,numCols);
    coloredArray(1) = 1;
    counter = 1;
    while kx < numCols
        counter = counter+1;
        kx;
        coloredArray(kx) = 1;
        if newColor == true
            a=0;
            b=256;          
            randomColor = [a+(b-a).*rand, a+(b-a).*rand, a+(b-a).*rand];
        end;
        depth = A(ix,kx,3);
        A(ix,kx,:) = randomColor;
        d = depth;
        jx = kx + double(d);
        kx = jx;
        if kx >= numCols
            newColor = true;
            logicalColoredArray = coloredArray==0;
            n=1:length(logicalColoredArray);
            [n out] = max(logicalColoredArray./n);
            out;
            if out ~= 1
                kx=out;
                coloredArray(kx) = 1;
            end;
        else
            newColor = false;
            coloredArray(kx) = 1;
        end;
    end;
end;
A(5,1,:)
%imagesc(A)
       