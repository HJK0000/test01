<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Command 객체 연습 페이지</h1>
    <hr>
    ${simpleBbsDto.title} <!--멤버객체의 클래스 이름이랑 일치해야 한다. SimpleBbsDto 를 받아오는 거니 simpleBbsDto. 라고 해야 title을 받아올 수 있다. -->
    <!--컨트롤러에서 dto라고 받았다고 dto로 하면안됨-->
</body>
</html>