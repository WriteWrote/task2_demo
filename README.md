# task2_demo


ДДА алгоритм

k = dy/dx;
формула, которую мы используем для рисования прямых более горизонтальных:
y = k(x - x1) + y1;
формула для рисования прямых более вертикальных:
x=1/k(y-y1) + x1;


Алгоритм Бризенхейма

dx = x2-x1;         k = dy/dx;
dy = y2-y1;

y - y1 / =  x - x1 /
y2 - y1     x2 - x1

y = (x - x1)dy/dx + y1;
Любое уравнение прямой описывает, принадлежит ли некая точка этой прямой или нет.
(x - x1)dy - (y-y1)dx = 0;

F(x,y) = (x - x1)dy - (y-y1)dx;
Имея эту функцию, мы можем определить, где находится точка относительно прямой.
0 => на ней;
-1 => над ней;
+1 => под ней;

Проверим, в какую точку нам двигаться дальше. current point (xp, yp):
(xp, yp) = (xp+1, yp+1);
d = F(xp+1, yp +1/2);

d<0 => d' = F(xp+2, yp+1);
delta_d = d' - d;
delta_d = dy;
то есть, если мы знаем текущее d<0, то можем добавить dy, и будем знать следующее д.

d>0 => d' = F(xp+2, yp + 3/2);
delta_d = d' - d = dy-dx;

d=0 => то следующая точка будет на линии.

Всякое d вычисляется на основе предыдущего, поэтому начальное d = F(x1 + 1; y1 + 1/2) = dy - dx/2 = 2dy - dx;
=>  d0 = 2dy - dx;
=> delta_d тоже умножается на 2:
    delta_d = 2d - 2dx   либо   2dy;



Пару слов об алгоритме Ву: он осуществляет сглаживание. Мы закрашиваем не один, а два пикселя, когда выбираем следующий, но с разной интенсивностью.
Как вычислить интенсивность: если у нас есть два пикселя со своими расстояниями, то мы должны единицу непрозрачности распределить по двум пикселям в пропорции от их дальности.
