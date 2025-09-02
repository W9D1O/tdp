{3.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).
b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)
c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente
encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra
en el vector.}

program tp2ej3;

const
	maxvec = 20;
	min = 	300;
	max =  1500;
type
	indice = -1..20;
	arr = array[1..maxvec]of integer;

function Nrandom():integer;
begin
	Nrandom:= random(max-min+1)+min;
end;

procedure CargarVector(var v:arr;dim:integer);
begin
	if(dim < 20)then begin
		dim:= dim +1;
		v[dim]:= Nrandom();
		CargarVector(v,dim);
		end;
end;

procedure cambio(var i,j:integer);
var
	aux:integer;
begin
	aux:= i;
	i:= j;
	j:=aux;
end;


//Cambiar este modulo
procedure Ordenar(var v:arr);
var
	i,j,pos,menor:integer;
begin
	menor:= maxint;
	for i:= 1 to maxvec-1 do begin
		for j:= i to maxvec do
			if(v[j] < menor)then begin
				menor:= v[j];
				pos:= j;
				end;
		cambio(v[i],v[pos]);
		menor:= maxint;
		
		end;
end;
procedure imp(v:arr);
var
	i:integer;
begin
	for i:= 1 to maxvec do
		writeln(v[i]);
end;

function EsCero(n:indice):indice;
begin
	n:= n div 2;
	if(n = 0)then
		n:= 1;
	EsCero:= n;
end;

Procedure busquedaDicotomica (v: arr; ini,fin: indice; dato:integer;
							  var pos: indice);

begin

	if(v[pos] <> dato)then
		if(pos > ini) and (v[pos] > dato)then
			begin
			writeln('estoy en if');
			writeln(pos);
			pos:= pos - EsCero(pos);
			busquedaDicotomica(v,ini,fin,dato,pos)
			end
			else
				if(pos < fin) and (v[pos] < dato)then begin
					writeln('estoy en else');
					writeln(pos);
					pos:= pos + EsCero(fin-pos);
					busquedaDicotomica(v,ini,fin,dato,pos);
					end;
	if(pos >= ini) and (pos <= fin)then
		if(v[pos] <> dato)then
			pos:= -1;
end;

var
	v:arr;
	dim,dato:integer;
	ini,fin,pos:indice;
	
begin
	randomize;
	dim:= 0;
	CargarVector(v,dim);
	imp(v);
	Ordenar(v);
	writeln();
	writeln('Ordenado:');
	imp(v);
	ini:= 1;
	fin:= maxvec;
	pos:= fin div 2;
	writeln('Ingrese valor a abuscar: ');
	readln(dato);
	busquedaDicotomica(v,ini,fin,dato,pos);
	writeln(pos);
end.
