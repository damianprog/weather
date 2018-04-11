<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="eng">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Weather</title>
<link type="text/css" rel="stylesheet" href="/css/main.css" />
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>

<body background="/css/images/mountainsgreybg.jpg">

	<div id="container">

		<div id="location">
			<h1 style="display: inline">${city}</h1>
			<form id="changeForm" action="/weather/main" method="GET">
				<input id="cityInput" type="text" name="city" required="required"> <input
					type="submit" value="Change"/>
				<c:choose>
					<c:when test="${!empty cannotFind}">
						<span style="color: red">Cannot find this city</span>
					</c:when>
				</c:choose>
			</form>
			<h4>${country}</h4>
		</div>

		<div id="logo">
			<a href="https://www.yahoo.com/?ilc=401" target="_blank"> <img
				src="https://poweredby.yahoo.com/white.png" width="134" height="29" />
			</a>
		</div>

		<div id="temperature">
			<p style="font-size: 30px">${channel.item.condition.text}</p>
			<br>
			<p style="font-size: 72px">${temperature}&#8451;</p>
		</div>

		<div id="leftSide">

			<div id="forecast">

				<div class="content">
					Forecast
					<hr>
					<table class="forecastTable">
						<c:forEach var="tempFore" items="${forecast}">
							<tr>
								<td>${tempFore.day}</td>
								<td>${tempFore.text}</td>
								<td class="numTd">${tempFore.high}</td>
								<td class="numTd"><span style="color: #a5d6ff">${tempFore.low}</span></td>
							</tr>
						</c:forEach>

					</table>
				</div>

			</div>

		</div>

		<div id="rightSide">

			<div class="details">

				<div class="content">
					Details
					<hr>
					<table class="detailsTable">
						<tr>
							<td class="leftTd">Wind Speed</td>
							<td>${channel.wind.speed} km/h</td>
						</tr>
						<tr>
							<td class="leftTd">Humidity</td>
							<td>${channel.atmosphere.humidity}%</td>
						</tr>
						<tr>
							<td class="leftTd">Visibility</td>
							<td>${channel.atmosphere.visibility}km</td>
						</tr>
						<tr>
							<td class="leftTd">UV Index</td>
							<td>${channel.atmosphere.rising}</td>
						</tr>
						<tr class="leftTd">
							<td>Pressure</td>
							<td>${channel.atmosphere.pressure} milibars</td>
						</tr>
					</table>
				</div>

			</div>

			<div class="sun">

				<div id="sunContent">
					<div class="half-circle"></div>
					<img style="margin-left:65px; float:left" src="/css/images/contrast.png">
					<img style="margin-left:165px; float:left" src="/css/images/contrast.png">
					<div style="clear:both"></div>
					<hr style="margin-top: 0px; margin-bottom: 0px">
					<div id="sunrise" style="margin-left:50px; float:left;">${channel.astronomy.sunrise}</div>
					<div id="sunset" style="margin-left:150px; float:left;">${channel.astronomy.sunset}</div>
				</div>

			</div>

		</div>

	</div>

</body>

</html>