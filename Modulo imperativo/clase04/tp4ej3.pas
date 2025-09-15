program tp4ej3;

type
	TVenta = record
		codV:integer;
		codp:integer;
		cantuni:integer;
		precioUnitario:real;
		end;
		
	TProducto = record
		codP:integer;
		totalven:integer;
		MontoTotal:real;
		end;
		
	arbol = ^raiz;
	
	raiz = record
		datos:TProducto;
		HD:arbol;
		HI:arbol;
		end;

procedure LeerVenta(var datos:TVenta);
begin
	datos.codV:= random(152) - 1;
	datos.codP:= random(500) + 1;
	datos.cantuni:= random(50) + 1;
	datos.precioUnitario:= random()*100;
end;

procedure Empaquetar(venta:Tventa;var prod:TProducto);
	function MontoTotal(cant:integer;precio:real):real;
	begin
		MontoTotal:= precio * cant;
	end;
	
begin
	prod.codP:= venta.codP;
	prod.totalVen:= venta.cantuni;
	prod.MontoTotal:= MontoTotal(venta.cantuni,venta.precioUnitario);
end;

procedure InsertarElemento(var a:arbol;datos:TProducto);
begin
	if(a = nil)then begin
		new(a);
		a^.datos:= datos;
		a^.HD:= nil;
		a^.HI:= nil;
		end
		else
		if(datos.codp = a^.datos.codP)then begin
			a^.datos.totalVen:= a^.datos.totalVen + datos.totalVen;
			a^.datos.MontoTotal:= a^.datos.MontoTotal + datos.MontoTotal
		end
			else
			if(datos.codP > a^.datos.codP)then
				InsertarElemento(a^.HD,datos)
				else
					InsertarElemento(a^.HI,datos);
end;

procedure GenerarArbol(var a:arbol);
var
	venta:Tventa;
	producto:TProducto;
begin
	LeerVenta(venta);
	if(venta.codV <> -1)then begin
		Empaquetar(venta,producto);
		InsertarElemento(a,producto);
		GenerarArbol(a);
		end;
end;

procedure ImpArbol(a:arbol);
begin
	if(a <> nil)then begin
		ImpArbol(a^.HI);
		writeln(a^.datos.codP,' ',a^.datos.totalVen,' ',a^.datos.MontoTotal:0:2);
		ImpArbol(a^.HD);
		end;
end;

function MayorCodigo(a:arbol):integer;
	procedure BuscarMayor(a:arbol;var cod,mayor:integer);
	begin
		if(a <> nil)then begin
			if(a^.datos.totalVen > mayor)then begin
				mayor:= a^.datos.totalVen;
				cod:= a^.datos.codP;
				end;
			BuscarMayor(a^.HI,cod,mayor);
			BuscarMayor(a^.HD,cod,mayor);
			end;
	end;
var
	cod,mayor:integer;
begin
	mayor:= -1;
	cod:= -1;
	BuscarMayor(a,cod,mayor);
	MayorCodigo:=cod;
end;

function CantidadDeCodigosMenores(a:arbol;cod:integer):integer;
begin
	if(a = nil)then
		CantidadDeCodigosMenores := 0
		else
			if(cod > a^.datos.codP)then begin
				CantidadDeCodigosMenores:= 
				CantidadDeCodigosMenores(a^.HD,cod) +
				CantidadDeCodigosMenores(a^.HI,cod) + 1;
				end
				else
					CantidadDeCodigosMenores:=
					CantidadDeCodigosMenores(a^.HD,cod) +
					CantidadDeCodigosMenores(a^.HI,cod);
					
end;

function SumaTotalDeMontos(a:arbol;LimInf,LimSup:integer):real;
begin
	if(a = nil)then
		SumaTotalDeMontos:= 0
		else
			if(a^.datos.codP > LimInf) and
			(a^.datos.codP < LimSup)then
			SumaTotalDeMontos:= SumaTotalDeMontos(a^.HD,LimInf,LimSup)+
			SumaTotalDeMontos(a^.HI,LimInf,LimSup) + a^.datos.MontoTotal
			else
			SumaTotalDeMontos:= SumaTotalDeMontos(a^.HD,LimInf,LimSup)+
			SumaTotalDeMontos(a^.HI,Liminf,LimSup);
end;			

var
	ar:arbol;
	cod,li,ls:integer;
begin
	randomize;
	ar:= nil;
	GenerarArbol(ar);
	ImpArbol(ar);
	writeln('Codigo Con mayor cantidad de unidades vendidas: ',
			MayorCodigo(ar));
	writeln('Ingrese codigo de producto: ');
	readln(cod);
	writeln('Cantidad de codigos menores: ',
			CantidadDeCodigosMenores(ar,cod));
	writeln('Ingrese Limite Inferior: ');
	readln(li);
	writeln('Ingrese Limite Superior: ');
	readln(ls);
	writeln(SumaTotalDeMontos(ar,li,ls):0:2);
end.
