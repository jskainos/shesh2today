CREATE TABLE `sales` (
  `employee_number` int(11) DEFAULT NULL,
  `commissionRate` decimal(3,2) DEFAULT NULL,
  KEY `empNo_idx` (`employee_number`),
  CONSTRAINT `empNo` FOREIGN KEY (`employee_number`) REFERENCES `employee` (`employee_number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `sesh2today`.`sales` 
ADD COLUMN `totalSales` DECIMAL(11,2) NULL AFTER `commissionRate`;

