# ProyectoFerreluzo
es un proyecto de administración de local, se encarga de la venta facturación y registros de un local

Programado en Java implementa las librerías itextpdf 5.5.9, jcalendar1.3.3 y jdom 2.0.6

El programa permite llevar la administración de un local a través de un inventario, caja y registro contable

El programa permite crear artículos los cuales poseen los siguientes datos: <br/>
  Nombre* <br/>
  ID# <br/>
  Familia <br/>
  Código de barrar <br/>
  Existencias <br/>
  Descripción <br/>
  Costo* (en Bs.) <br/>
  IVA* <br/>
  Precio de venta* (en Bs.) <br/>
  
  (*) Los datos obligatorios que tiene que tener todo articulo <br/>
  (#) se asigna automáticamente al guardar el articulo <br/>
  
Permite agregar clientes con los siguientes datos <br/>
  CI/RIF <br/>
  Nombre <br/>
  Dirección <br/>
  Teléfono <br/>
  
  Todos los datos son obligatorios <br/>
  
Se pueden vender productos los cuales requieren agregar un cliente nuevo o un cliente ya almacenado en los datos del programa, agregando productos y como forma opcional una fecha en la cual se vende el producto (por defecto la fecha actual), esta venta se pueden guardar como ventas en espera las cuales se indicaran con el número total de ventas en espera en el botón de caja en el menú principal <br/>

cada venta se le asigna finaliza creando una factura la cual tendrá todos los datos de la venta y se guardara en el sistema en forma de PDF y en un xml <br/>

-todas las facturas realizadas se pueden ver desde el menú de registro contable donde se podrán organizar por fechas  y donde se podrán ver los datos de:<br/>
  Fecha <br/>
  Número de factura <br/>
  Sub-total <br/>
  IVA <br/>
  Total <br/>
  
- es posible imprimir un PDF con el listado completo de las facturas del sistema <br/>
- se pueden eliminar las facturas que ya no se necesiten <br/>

además de las facturadas también es posible ver los artículos más vendidos en un menú aparte en el registro contable, en el cual se muestra una lista con los artículos más vendidos y aparte el artículo más demandado que se haya registrado <br/>




