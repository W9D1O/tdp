program numale;

const
    fin = 20;

procedure veinte();
var
  i,n:integer;
begin
	randomize;
	for i:= 1 to 20 do begin
		n:= random(100);
		writeln(n);
	end;
end;

procedure LeerNum(var n,a,b:integer);
begin
	writeln('Ingrese cantidad de numeros a impriamir o el numero que no desea que se imprima: ');
	readln(n);
	writeln('Ingrese limite inferior: ');
	readln(a);
	writeln('Ingrese limite superior: ');
	readln(b);
end;

function InitNum(a,b:integer):integer;
begin
	randomize;
	InitNum:= random(b-a) +a +1;
end;

procedure Nrango();
var
 i,n,a,b,ale:integer;
begin
	LeerNum(n,a,b);
	randomize;
	for i:= 1 to n do begin
		ale:= random(b - a) + a +1;
		writeln(ale);
	end;
	
end;

procedure NrangoNF();
var
	f,a,b,ale:integer;
begin
	LeerNum(f,a,b);
	//randomize;
	ale:= InitNum(a,b);
	while(ale <> f) do begin
		writeln(ale);
		ale := InitNum(a,b);
	end;
end;

var
	ale:integer;
begin
	randomize;
	ale:=random(100);
	writeln('El numero es: ',ale);
	//veinte();
	//Nrango();
	NrangoNF();
	
end.
