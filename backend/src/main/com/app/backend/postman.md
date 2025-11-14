# Pruebas Postman para Gestión de Usuarios

## 1. Obtener todos los usuarios
**Método:** GET  
**URL:** `http://localhost:8080/api/users`
**Headers:**
- Authorization: Bearer `<token>`

---

## 2. Obtener usuario por ID
**Método:** GET  
**URL:** `http://localhost:8080/api/users/{id}`
**Headers:**
- Authorization: Bearer `<token>`

---

## 3. Crear usuario
**Método:** POST  
**URL:** `http://localhost:8080/api/users`
**Headers:**
- Authorization: Bearer `<token>`
- Content-Type: application/json
**Body (JSON):**
```json
{
  "username": "nuevoUsuario",
  "email": "usuario@email.com",
  "password": "123456",
  "roles": ["COORDINADOR"]
}
```

---

## 4. Actualizar usuario
**Método:** PUT  
**URL:** `http://localhost:8080/api/users/{id}`
**Headers:**
- Authorization: Bearer `<token>`
- Content-Type: application/json
**Body (JSON):**
```json
{
  "username": "usuarioActualizado",
  "email": "nuevo@email.com",
  "roles": ["COORDINADOR"]
}
```

---

## 5. Eliminar usuario
**Método:** DELETE  
**URL:** `http://localhost:8080/api/users/{id}`
**Headers:**
- Authorization: Bearer `<token>`

---

> Reemplaza `<token>` por el JWT válido y `{id}` por el ID del usuario correspondiente.