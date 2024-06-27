USE PENCAUCU;

INSERT INTO usuario(email, contrasenia, nombre, apellido, avatar_path, id_carrera, es_administrador) 
VALUES (
    "admin@pencaucu.com",
    -- Password: 'admin' - already hashed for compatibility reasons
    "$2a$11$FZ9sQz9001/9fqiy98j2kOk4b29NnAUn.2NaNQNBSYf7hSP7MmPva",
    "Administrador",
    "PencaUCU",
    "admin.png",
    4,
    1
  );

  INSERT INTO torneo(nombre, anio)
  VALUES (
    "Copa América USA",
    "2024"
  );