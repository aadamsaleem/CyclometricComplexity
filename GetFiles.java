#include<stdio.h>
#include<conio.h>
#include<math.h>
int main()
int a,b,c,validInput=0,d;
double D;
printf("Enter the 'a' value: ");
scanf("%d",&a);
printf("Enter the 'b' value: ");
scanf("%d",&b);
printf("Enter the 'c' value: ");
scanf("%d",&c);
if ((a>=0)&&(a<=100)&&(b>=0)&&(b<=100)&&(c>=0)&&(c<=100)){
validInput=1;
if (a==0){
calidInput=-1;

if(validInput==1){
d=b*b-4a*c;
if(d==0){
printf("the roots are equal and are r1=r1 = %f\n",-b/(2*(float) a);

else if (d>0){
d=sqrt(d);
print("The roots are real nd are r1=%f and r2 = %f\n",(-b-D)/(2*a),(-b+D)/(2*a));
ý
else {
D=sqrt(-d)/(2*a);
printf9"The roots are imaginary and are r1==(%f,%f) and r2=( %f%f)\n", -b/(2.0*a),d,-b/(2.0*a),-D);
ý
ý
else if (validInput == 1){
printf("The values do not constitute a quadratic equation.");
ý
else {
printf("THE INPUTS BELONG TO INVALI RANGE.");
ý
getche();
return 1;
ý