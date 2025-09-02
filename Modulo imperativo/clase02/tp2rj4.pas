{4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero).}
program tp2ej4;

procedure ABinario(n:integer);
begin
	if(n <> 0)then begin
		Abinario(n div 2);
		write(n mod 2);
	end;
end;

procedure LeerNum(var n:integer);
begin
	writeln('Ingrese un numero: ');
	readln(n);
end;

var
	n:integer;
begin
	LeerNum(n);
	while(n <> 0)do begin
	writeln('En binario es: ');
	Abinario(n);
	writeln();
	LeerNum(n)
	end;
end.
