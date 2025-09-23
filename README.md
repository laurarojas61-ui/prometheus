# EV02 Prometheus Web  
Proyecto académico desarrollado con Spring Boot, Maven y base de datos en memoria H2.  
Incluye los módulos: Inquilino, Alquiler, Pago, Perfil, Propiedad y Usuario.  

---

# Requisitos previos  
- Java 17 instalado  
- Maven 3.8+ instalado  
- Un IDE recomendado: IntelliJ IDEA o Eclipse  

---

# Configuración del proyecto  

# 1. Clonar el repositorio  
git clone https://github.com/tu_usuario/EV02_prometheus_web.git  

# 2. Entrar a la carpeta del proyecto  
cd EV02_prometheus_web  

# 3. Compilar el proyecto con Maven  
mvn clean install  

# 4. Ejecutar el proyecto  
mvn spring-boot:run  

# El servidor se iniciará en:  
http://localhost:8080  

---

# Base de datos H2  

# El proyecto usa H2 Database en memoria.  
# Accede a la consola desde tu navegador:  
http://localhost:8080/h2-console  

# Datos de conexión H2:  
- Driver Class: org.h2.Driver  
- JDBC URL: jdbc:h2:mem:testdb  
- User: sa  
- Password: (vacío)  

---

# Endpoints principales  

# Inquilinos  
GET /api/inquilinos  
POST /api/inquilinos  

# Alquileres  
GET /api/alquileres  
POST /api/alquileres  

# Pagos  
GET /api/pagos  
POST /api/pagos  

# Perfiles  
GET /api/perfiles  
POST /api/perfiles  

# Propiedades  
GET /api/propiedades  
POST /api/propiedades  

# Usuarios  
GET /api/usuarios  
POST /api/usuarios  

---

# Ejemplos JSON para pruebas en Postman  

# Crear Inquilino  
{
  "nombre":"Carlos Pérez",
  "documento":"123456789",
  "telefono":"3001234567",
  "correo":"carlos@example.com"
}  

# Crear Alquiler  
{
  "fechaInicio":"2025-01-01",
  "fechaFin":"2025-12-31",
  "meses":12,
  "montoMensual":1200000,
  "personas":3,
  "activo":true,
  "contrato":"CT-001",
  "inquilinoId":1,
  "propiedadId":1
}  

# Registrar Pago  
{
  "alquilerId":1,
  "fechaPago":"2025-02-01",
  "montoMensual":1200000,
  "alquilerPago":true,
  "compAlquiler":"COMP-001",
  "reciboAgua":"AGUA-001",
  "compAgua":"COMP-AGUA-001",
  "reciboEnergia":"ENE-001",
  "compEnergia":"COMP-ENE-001",
  "reciboGas":"GAS-001",
  "compGas":"COMP-GAS-001"
}  

# Crear Perfil  
{
  "nombre":"Laura Rojas",
  "documento":"987654321",
  "telefono":"3109876543",
  "correo":"laura@example.com",
  "contraseña":"12345"
}  

# Crear Propiedad  
{
  "nombre":"Apartamento Norte",
  "direccion":"Calle 123 #45-67",
  "descripcion":"Apartamento de 3 habitaciones",
  "rentado":false
}  

# Crear Usuario  
{
  "name":"Admin",
  "email":"admin@example.com",
  "password":"admin123"
}  

---

# Pruebas  

# Para ejecutar las pruebas automáticas:  
mvn test
