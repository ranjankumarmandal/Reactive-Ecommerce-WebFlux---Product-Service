CREATE TABLE IF NOT EXISTS ranjanschema.products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DOUBLE PRECISION
);
