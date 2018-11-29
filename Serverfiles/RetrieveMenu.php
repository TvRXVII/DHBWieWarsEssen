<?php

    $con = mysqli_connect("localhost", "dhbwwe_user", "jhgcwbncskijioihe", "dhbwwe_data");

    $date = $_POST["date"];

    $statement = mysqli_prepare($con, "SELECT * FROM menus WHERE date = ?");
    mysqli_stmt_bind_param($statement, "s", $date);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $menu_id, $date, $dish1, $price1, $dish2, $price2, $dish3, $price3);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["dish1"] = $dish1;
        $response["price1"] = $price1;
        $response["menu2"] = $dish2;
        $response["price2"] = $price2;
        $response["menu3"] = $dish3;
        $response["price3"] = $price3;
    }

    echo json_encode($response);

?>