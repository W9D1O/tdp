program vectores;

const
	DF = 50;

type
	arr = array[1..DF]of integer;

procedure rango(var a,b:integer);
begin
	writeln('Ingrese limite inferior: ');
	readln(a);
	writeln('Ingrese limite superior: ');
	readln(b);
end;

function InitNum(a,b:integer):integer;
begin
	//randomize;
	InitNum:= random(b - a)+  +1;
end;

procedure CargarVector(var v:arr;var dl:integer);
var
	a,b,ale:integer;
begin
	randomize;
	rango(a,b);
	ale:= InitNum(a,b);
    while(ale <> 0) and (dl < DF)do begin
		dl:= dl + 1;
		v[dl]:= ale;
		ale:= InitNum(a,b);
    end;
end;

procedure ImpVector(v:arr;dl:integer);
var
i:integer;
begin
	for i:= 1 to dl do
		writeln(v[i],' ',i);
end;

var
	v:arr;
	dl:integer;
begin
	dl:= 0;
	CargarVector(v,dl);
	ImpVector(v,dl);
end.
