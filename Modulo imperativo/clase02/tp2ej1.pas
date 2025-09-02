{2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.
c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.
d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.
e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.}


program tp2ej2;

const
	INI = 100;
	FIN = 200;
type
	lis = ^nodo;
	nodo = record
		num:integer;
		sig:lis;
		end;
		
function Nrandom():integer;
begin
	Nrandom:= random(FIN-INI+1)+INI;
	end;


function  adelante(l:lis;n:integer):lis;
var
	aux:lis;
begin
	new(aux);
	aux^.num:= n;
	aux^.sig:= l;
	adelante:= aux;
end;
//b. Imprime los elementos de la lista
procedure ImpLis(l:lis);
begin
	if(l <> nil) then begin
		writeln(l^.num);
		l:= l^.sig;
		ImpLis(l);
		end;
end;

//c. Imprime los elementos de la lista en orden inverso
procedure ImpRevLis(l:lis);
var
	num:integer;
begin
	if(l <> nil)then begin
		num:= l^.num;
		l:= l^.sig;
		ImpRevLis(l);
		writeln(num);
		end
end;

// a. Crea una lista de numeros aleatorios
procedure RecurLis(var l:lis;n:integer);
begin
	n:= Nrandom();
	if(n <> INI)then begin
		RecurLis(l,n);
		end;
	l:= adelante(l,n);
	end;
{
* Solucion del compañero.
procedure implisrecinv(l:lis);
begin
	if(l <> nil)then begin
		implisrecinv(l^.sig);
		writeln(l^.num);
		end;
end;
}
// d. Devuelve el menor elemento de la lista
procedure Minimo(l:lis;var n:integer);
begin

	if(l <> nil)then begin
		if(n > l^.num)then
			n:= l^.num;
		l:= l^.sig;
		Minimo(l,n);
		end;
	
end;

procedure existe(l:lis;n:integer;var vf:boolean);
begin
	
	if(l <> nil) and (l^.num <> n)then begin
		existe(l^.sig,n,vf);
		end
		else
			if(l <> nil) and (l^.num = n)then
				vf:= true
	
end;
var
	n,min:integer;
	l:lis;
	vf:boolean;
begin
	l:= nil;
	randomize;
	n:=0;
	min:= MAXINT;
	Recurlis(l,n);
	writeln('Imprime la lista aen el orden almacenado.');
	writeln('-----------------------------------------');
	ImpLis(l);
	writeln();
	writeln('Imprime la lista de atras para adelante');
	writeln('---------------------------------------');
	writeln();
	ImpRevLis(l);
	//implisrecinv(l);
	Minimo(l,min);
	writeln('El vamor minimo es: ',min);
	writeln('Ingrese un numero: ');
	readln(n);
	vf:=false;
	existe(l,n,vf);
	writeln(vf);
	end.
