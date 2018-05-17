function [im2, im1] = crop_images(im2, im1)

[h1, w1, b1] = size(im1);
[h2, w2, b2] = size(im2);

minw = min(w1, w2);
brd = (max(w1, w2)-minw)/2;
if minw == w1 % crop w2
    im2 = im2(:, (ceil(brd)+1):end-floor(brd), :);
    tx = tx-ceil(brd);
else
    im1 = im1(:, (ceil(brd)+1):end-floor(brd), :);
    tx = tx+ceil(brd);    
end

minh = min(h1, h2);
brd = (max(h1, h2)-minh)/2;
if minh == h1 % crop w2
    im2 = im2((ceil(brd)+1):end-floor(brd), :, :);
    ty = ty-ceil(brd);
else
    im1 = im1((ceil(brd)+1):end-floor(brd), :, :);
    ty = ty+ceil(brd);    
end
