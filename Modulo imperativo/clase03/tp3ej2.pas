program tp3ej2;



const
	diamax = 31;
	mesmax = 12;
	aniomax = 2100;
	aniomin = 1940;
	unimax = 100;
	lenmaxf = 10;

type
	dia = 1..diamax;
	mes = 1..mesmax;
	anio = aniomin..aniomax;
	Tfecha = string[11];
	ventas = record
		codP:integer;
		fecha:Tfecha;
		cantUni:integer;
		end;
		
	arbol1 = ^nodoar1;
	nodoar1 = record
		datos:ventas;
		HD:arbol1;
		HI:arbol1;
		end;
	UnidadesVen = record
		codP:integer;
		CanTotal:integer;
		end;
		
	arbol2 = ^nodoar2;
	nodoar2 = record
		datos:UnidadesVen;
		HD:arbol2;
		HI:arbol2;
		end;
	Lista = record
		fecha:Tfecha;
		cantuni:integer;
		end;
		
	TLis = ^nodo;
	nodo = record
		datos:Lista;
		sig:Tlis;
		end;
	LisVen = record
		codP:integer;
		lis:Tlis;
		end;
		
	arbol3 = ^nodoar3;
	nodoar3 = record
		datos:Lisven;
		HD:arbol3;
		HI:arbol3;
		end;

function bisiesto(anio:integer):boolean;
var
	vf:boolean = false;
begin
	if(anio mod 4 = 0) and ((anio mod 100 <> 0) or (anio mod 400 = 0))
	then
		vf:= true;
	bisiesto:= vf;
end;
	
function CantDias(mes,anio:integer):dia;
	var
	d:dia;
begin
	if( mes = 4) or (mes = 6) or (mes = 9) or (mes = 11)
	then
		d:= random(30)+1
	else if(mes = 2) then
			if(bisiesto(anio))then
				d:=random(29)+1
			else
				d:=random(28)+1
		else
			d:=random(31)+1;
	CantDias:=d;
end;
			

function Astring(n:integer):string;
var
	dig:integer;
	aux:string;
begin
	aux:= '';
	while(n <> 0)do begin
		dig:= n mod 10;
		n:= n div 10;
		aux:=char(48 + dig)	+aux;
	end;
	Astring:= aux;
end;

function fecha():Tfecha;
	
var
	f:Tfecha;
	separador:char = '/';
	n:array[1..3]of integer;
	i:integer;
begin
	f:= '';
	n[3]:= random(aniomax-aniomin+1)+aniomin;
	n[2]:=random(mesmax)+1;
	n[1]:=CantDias(n[2],n[3]);
	for i:= 1 to 3 do begin
		if(n[i] > 9)then
			f:= f + Astring(n[i])
		else
			f:= f + '0' + Astring(n[i]);
		if(i < 3)then
			f:= f + separador;
	end;
	fecha:=f;
end;

procedure VentasRandom(var dato:ventas);

begin
	dato.codP:= random(401);
	dato.cantUni:= random(unimax)+1;
	dato.fecha:= fecha();
	//writeln(dato.fecha);
end;

procedure InsEleA1(var a1:arbol1;v:ventas);

begin
	//Genera el nodo inicial.
	if(a1 = nil)then begin
		new(a1);
		a1^.datos:=v;
		a1^.HD:= nil;
		a1^.HI:= nil;
		end
		else
		 if(v.codP > a1^.datos.codP)then
			InsEleA1(a1^.HD,v)
		else begin
			InsEleA1(a1^.HI,v);
			end;
end;

procedure InsEleA2(var a2:arbol2;codp,cantuni:integer);

begin
	//Genera el nodo inicial.
	if(a2 = nil)then begin
		new(a2);
		a2^.datos.codP:= codp;
		a2^.datos.canTotal:= cantuni;
		a2^.HD:= nil;
		a2^.HI:= nil;
		end
		else
			if(codp = a2^.datos.codp)then
				a2^.datos.canTotal:= a2^.datos.canTotal + cantuni
			else if(codp > a2^.datos.codp)then
					InsEleA2(a2^.HD,codp,cantuni)
				else
					InsEleA2(a2^.HI,codp,cantuni);
				
end;

//agregamos nodos a la lista
function adelante(l:Tlis;datos:Lista):Tlis;
var
	aux:Tlis;
begin
	new(aux);
	aux^.datos:= datos;
	aux^.sig:= l;
	adelante:= aux;
end;


//Agrega elementos al arbol3
procedure InsEleA3(var a3:arbol3;datos:Lista;codP:integer);

begin
	if(a3 = nil)then begin
		new(a3);
		a3^.datos.codP:= codP;
		a3^.datos.lis:= nil;
		a3^.datos.lis:= adelante(a3^.datos.lis,datos);
		a3^.HD:= nil;
		a3^.HI:= nil;
		end
		else if(a3^.datos.codP = codP)then begin
			a3^.datos.lis:= adelante(a3^.datos.lis,datos)
			end
			else
				if(a3^.datos.codP > codP)then begin
					InsEleA3(a3^.HD,datos,codP)
					end
				else
					begin
					InsEleA3(a3^.HI,datos,codP)
					end;
					
end;

function ListaVentas(f:Tfecha;cantuni:integer):Lista;
var
	datos:Lista;
begin
	datos.fecha:= f;
	datos.cantuni:=cantuni;
	ListaVentas:= datos;
end;

Procedure GenerarArboles(var a1:arbol1;var a2:arbol2;var a3:arbol3);
var
	v:ventas;
begin
	VentasRandom(v);
	while(v.codP <> 0)do begin
		InsEleA1(a1,v);
		InsEleA2(a2,v.codP,v.cantuni);
		InsEleA3(a3,ListaVentas(v.fecha,v.cantuni),v.codP);
		VentasRandom(v);
	end;
end;

procedure LeerFecha(var f:Tfecha);
begin
	writeln('Ingrese fecha[dd/mm/aaaa]: ');
	readln(f);
end;

function FechaValida(f:Tfecha):boolean;
var
	i:integer;
	vf:boolean = true;
begin
	for i:= 1 to lenmaxf do
		if(ord(f[i]) < 47) or (ord(f[i]) > 57)then begin
			vf:=false;
			break
			end;
	FechaValida:= vf;
end;


procedure VentasEnFecha(var f:Tfecha);

begin
	LeerFecha(f);
	while(not FechaValida(f))do begin
		WriteLn('La fecha ingresada no es valida.');
		WriteLn('El fomato valido es el siguiente.');
		WriteLn('Ejemplo: 99/99/9999');
		LeerFecha(f)
		end;
		
end;



function CantProdVendidos(a: arbol1; f: Tfecha): integer;
begin
  if a = nil then
    CantProdVendidos := 0
  else begin
    if a^.datos.fecha = f then
      CantProdVendidos := a^.datos.cantuni +
                          CantProdVendidos(a^.HI, f) +
                          CantProdVendidos(a^.HD, f)
    else
      CantProdVendidos := CantProdVendidos(a^.HI, f) +
                          CantProdVendidos(a^.HD, f);
  end;
end;

function CantProdT(a: arbol1): integer;
begin
  if a <> nil then
    CantProdT := a^.datos.cantuni +
                 CantProdT(a^.HI) +
                 CantProdT(a^.HD)
  else
    CantProdT := 0;
end;

procedure ProductosEnFecha(a:arbol1;var n:integer);
var
	f:Tfecha;
begin
	VentasEnFecha(f);
	n:= CantProdVendidos(a,f);
	writeln(n);
end;

//Estudiar bien este odulo
procedure codmax(a:arbol2;var cmax,max:integer);
begin
	if(a <> nil)then  begin
		if(a^.datos.cantotal > max)then begin
			max:= a^.datos.canTotal;
			cmax:= a^.datos.codP;
			end;
			Codmax(a^.HI,cmax,max);
			Codmax(a^.HD,cmax,max);
			end;
end;


function UniTotal(l:Tlis):Integer;
begin
	if(l = nil)then
		UniTotal:= 0
		else
		UniTotal:= l^.datos.cantuni + UniTotal(l^.sig);
		
end;

procedure A3cmax(a:arbol3;var cmax,max:integer);
var
	auxm:integer;
begin
	if(a <> nil)then begin
		auxm:= UniTotal(a^.datos.lis);
		if(auxm > max)then begin
			max:= auxm;
			cmax:= a^.datos.codP;
			end;
		A3cmax(a^.HD,cmax,max);
		A3cmax(a^.HI,cmax,max);
		end;
end;


procedure Imp1(a:arbol1);

begin
	if(a <> nil)then begin 
		Imp1(a^.HD);
		writeln(a^.datos.fecha);
		Imp1(a^.HI)
		end;
end;

procedure Imp2(a:arbol2);

begin
	if(a <> nil)then begin 
		Imp2(a^.HD);
		writeln(a^.datos.codP,' ',a^.datos.CanTotal);
		Imp2(a^.HI)
		end;
end;
	
var
 a1:arbol1;
 a2:arbol2;
 a3:arbol3;
 n,cod,a3cm,a3mx:integer;
begin
	a1:= nil;
	a2:= nil;
	a3:= nil;
	randomize;
	GenerarArboles(a1,a2,a3);
	cod:=-1;
	//VentasEnFecha(fecha);
	//writeln(FechaValida(fecha()));
	Imp1(a1);
	ProductosEnFecha(a1,n);
	//n:= CantProdT(a1);
	n:= -1;
	a3cm:= -1;
	a3mx:= -1;
	codmax(a2,cod,n);
	Imp2(a2);
	writeln(cod);
	A3cmax(a3,a3cm,a3mx);
	writeln(a3cm);
end.
