use `goldeneye_db`;

DELETE FROM `goldeneye_db`.`metals` where 1=1;

INSERT INTO `goldeneye_db`.`metals`
(`code`,
`display`)
SELECT 'Au','金/Gold' 
UNION ALL
SELECT 'Ag','银/Silver' 
UNION ALL
SELECT 'Pt','铂/Platinum' 
UNION ALL
SELECT 'Pd','钯/Palladium' 
UNION ALL
SELECT 'Rh','铑/Rhodium';

DELETE FROM `goldeneye_db`.`units` where 1=1;

INSERT INTO `goldeneye_db`.`units`
(`code`,
`display`)
SELECT 'CNY.g','人民币/克' 
UNION ALL
SELECT 'USD.oz','美元/盎司' 
UNION ALL
SELECT 'GBP.oz','英镑/盎司' 
UNION ALL
SELECT 'EUR.oz','欧元/盎司';