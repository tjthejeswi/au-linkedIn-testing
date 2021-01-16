-- get a list of all product names, and their locations, that had a transaction in Feb-2020
SELECT  distinct  product.Product_Name, location.Location_Name
FROM Sales_Transaction_Table sales
JOIN Product_Table product
ON sales.Product_id = product.ID
JOIN Location_Table location
on sales.Location_id = location.ID
where YEAR(sales.Trans_Date) = 2020
and MONTH(sales.Trans_Date) = 02

-- get total sell price for each product in Jan-2020

SELECT  sum(sales.Sell_Price), product.Product_Name
FROM Sales_Transaction_Table sales
JOIN Product_Table product
ON sales.Product_id = product.ID
where YEAR(sales.Trans_Date) = 2020
and MONTH(sales.Trans_Date) = 01
group by product.Product_Name;

-- get total sell price for each location in Jan-2020

SELECT  sum(sales.Sell_Price), location.Location_Name
FROM Sales_Transaction_Table sales
JOIN Locaiton_Table location
ON sales.Locaiton_id = location.ID
where YEAR(sales.Trans_Date) = 2020
and MONTH(sales.Trans_Date) = 01
group by product.Product_Name;


-- get total sell price for each product and each location in Jan-2020

SELECT  sum(sales.Sell_Price), product.Product_Name, location.Location_Name
FROM Sales_Transaction_Table sales
JOIN Product_Table product
ON sales.Product_id = product.ID
JOIN Location_Table location
on sales.Location_id = location.ID
where YEAR(sales.Trans_Date) = 2020
and MONTH(sales.Trans_Date) = 01
group by product.Product_Name, location.Location_Name;