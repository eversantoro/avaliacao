-- BANCO: avaliacao
-- USUARIO: avaliacao
-- SENHA: avaliacao

CREATE TABLE `avaliacao`.`veiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(100) NOT NULL,
  `marca` VARCHAR(100) NULL,
  `placa` VARCHAR(12) NOT NULL,
  `fabricacao` DATE NULL,
  PRIMARY KEY (`id`));