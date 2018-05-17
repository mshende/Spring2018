close all; % closes all figures

% read images and convert to single format
im1 = im2single(imread('./sunflower.jpg'));
im2 = im2single(imread('./white_flower.jpg'));

im1 = rgb2gray(im1); % convert to grayscale
im2 = rgb2gray(im2);
imagesc(log(abs(fftshift(fft2(im1)))));
pause;
imagesc(log(abs(fftshift(fft2(im2)))));

% use this if you want to align the two images (e.g., by the eyes) and crop
% them to be of same size
[im2, im1] = align_images(im2, im1);
% A = maya_align(im1, im2);
% im1 = A;
% [im2, im1] = crop_images[im2, im1];

% uncomment this when debugging hybridImage so that you don't have to keep aligning
% keyboard; 

%% Choose the cutoff frequencies and compute the hybrid image (you supply
%% this code)
arbitrary_value = 100;
cutoff_low = arbitrary_value;
cutoff_high = arbitrary_value; 
im12 = hybridImage(im1, im2, cutoff_low, cutoff_high);

%% Crop resulting image (optional)
figure(1), hold off, imagesc(im12), axis image, colormap gray
disp('input crop points');
[x, y] = ginput(2);  x = round(x); y = round(y);
im12 = im12(min(y):max(y), min(x):max(x), :);
figure(1), hold off, imagesc(im12), axis image, colormap gray

%imagesc(log(abs(fftshift(fft2(im12)))));
%% Compute and display Gaussian and Laplacian Pyramids (you need to supply this function)
% N = 5; % number of pyramid levels (you may use more or fewer, as needed)
% %gaussIm12 = imgaussfilt(im12, 3);
% %laplaceIm12 = im12 - gaussIm12;
% tempGauss = im12;
% tempLaplace = im12;
% for ix=1:N
%     tempGauss = tempGauss(1:2:end, 1:2:end);
%     tempLaplace = tempLaplace(1:2:end, 1:2:end);
%     tempGauss = imgaussfilt(tempGauss, 2);
%     tempLaplace = tempLaplace - tempGauss;
%     subplot(1,2,1)
%     imshow(tempGauss)
%     title('Gaussian Pyramid')
%     subplot(1,2,2)
%     imshow(tempLaplace)
%     title('Laplacian Pyramid')
%     pause;
% end;