function im12 = hybridImage(im1, im2, cutoff_low, cutoff_high);

% low pass filter im1
gaussIm1 = imgaussfilt(im1,6,'FilterSize', cutoff_low+1);
imshow(gaussIm1)
pause;

% high pass filter im2
gaussIm2 = imgaussfilt(im2, 4, 'FilterSize', cutoff_high+1);
laplacianIm2 = im2-gaussIm2;

im12 = gaussIm1 + laplacianIm2;

% im12 = laplacianIm2;
imshow(laplacianIm2)
pause;