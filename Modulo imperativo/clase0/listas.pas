program listas;

const
	LimSup = 150;
	LimInf = 100;
	NoDeseado = 120;
type
	lis = ^nodo;
	nodo = record
		num:integer;
		sig:lis;
		end;

function RandRango():integer;
begin
	RandRango:= random(LimSup-LimInf)+LimInf+1;
end;

procedure adelante(var l:lis;num:integer);
var
	aux:lis;
begin
	new(aux);
	aux^.num:= num;
	aux^.sig:= l;
	l:= aux;
	end;

procedure CargarLista(var l:lis);
var
	num:integer;
begin
	num:= RandRango();
	while(num <> NoDeseado)do begin
		adelante(l,num);
		num:=RandRango();
		end;
end;

procedure ImpLis(l:lis);
begin
	while(l <> nil)do begin
		writeln(l^.num);
		l:= l^.sig;
		end;
end;

function Existe(l:lis;num:integer):boolean;
var
	vf:boolean;
begin
	vf:= false;
	if(l^.num <> num)then
	while(l <> nil) and (l^.num <> num) do begin
		l:= l^.sig;
		if(l <> nil) and (l^.num = num)then
			vf:= true;
		end
	else
		if(l <> nil)then
			vf:= true;
	Existe:=vf;
end;
var
	l:lis;

begin
	l:= nil;
	randomize;
	CargarLista(l);
	ImpLis(l);
	writeln(Existe(l,23));
end.
