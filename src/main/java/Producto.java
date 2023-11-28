package Model;

public class Producto {
	
	  	private int id;
	    private String descripcion;
	    private int id_marca;
	    private double precio_compra;
	    private double precio_venta;
	    private int stock;
	    private int id_subcategoria;
		private boolean estado;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getId_marca() {
			return id_marca;
		}

		public void setId_marca(int id_marca) {
			this.id_marca = id_marca;
		}

		public double getPrecio_compra() {
			return precio_compra;
		}

		public void setPrecio_compra(double precio_compra) {
			this.precio_compra = precio_compra;
		}

		public double getPrecio_venta() {
			return precio_venta;
		}

		public void setPrecio_venta(double precio_venta) {
			this.precio_venta = precio_venta;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public int getId_subcategoria() {
			return id_subcategoria;
		}

		public void setId_subcategoria(int id_subcategoria) {
			this.id_subcategoria = id_subcategoria;
		}

		public boolean getEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		
}