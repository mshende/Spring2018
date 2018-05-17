function [shift_i, shift_j] = shiftPixels(base, toShift, shiftSize)

temp = toShift;
%min_error = (toShift(y, x) - base(y, x))^2
min_error = sum(sum((toShift - base).^2));
%min_error = sum(dot(toShift./norm(toShift), base./norm(base)));
shift_i = 0;
shift_j = 0;
for i=1:shiftSize
    for j=1:shiftSize
        temp = circshift(toShift, [i,j]);
%        temp_error = (temp(y,x)-base(y,x))^2
        temp_error = sum(sum((temp - base).^2));
%         temp_error = sum(dot(temp./norm(temp), base./norm(base)));
%         x = sprintf('error of this shift is %0.5g', temp_error);
%         y = sprintf('min error currently is %0.5g', min_error);
%         disp(x)
%         disp(y)
        if temp_error < min_error
            min_error = temp_error;
            shift_i = i;
            shift_j = j;
        end;
    end;
end;
