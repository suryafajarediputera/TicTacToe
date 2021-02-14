<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

        <html lang="en">

        <head>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
                crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
                integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
                integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
                crossorigin="anonymous"></script>
            <title>Tic Tac Toe</title>
            <link href="app.css" rel="stylesheet">
        </head>

        <body>
            <br>
            <div class="wrapper">
                <div id="content-wrapper" class="d-flex flex-column">
                    <div class="content">
                        <div class="container-fluid">
                            <div class="d-sm-flex align-items-center justify-content-between mb-4">
                                <h1 class="h3 mb-0 text-gray-800">Tic Tac Toe</h1>
                            </div>

                            <div class="row">
                                <!-- Form Section -->
                                <div class="col-xl-6 col-md-6 mb-4">
                                    <div class="card border-left-primary shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div
                                                        class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                        Board Size
                                                    </div>
                                                    <div class="row">

                                                        <c:choose>
                                                            <c:when test="${not empty formInput}">
                                                                <form:form action="/create" method="post"
                                                                    modelAttribute="formInput">
                                                                    <div class="row g-3">
                                                                        <div class="col-auto">
                                                                            <form:input type="number"
                                                                                class="form-control" id="boardSize"
                                                                                placeholder="Board Size" min="3"
                                                                                path="boardSize" />
                                                                        </div>

                                                                        <div class="col-auto">
                                                                            <button id="btnSubmit" type="submit"
                                                                                class="btn btn-primary mb-3">Create</button>
                                                                        </div>

                                                                        <div class="col-auto">
                                                                            <a href="/reset">
                                                                                <button id="btnReset" type="button"
                                                                                    class="btn btn-danger mb-3"
                                                                                    onclick="return confirm('Are you sure to reset game?')">Reset</button>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </form:form>
                                                            </c:when>

                                                            <c:otherwise>
                                                                <div class="row g-3">
                                                                    <div class="col-auto">
                                                                        <input type="number" class="form-control"
                                                                            id="boardSize" placeholder="Board Size"
                                                                            value="${boardSize}" disable
                                                                            path="boardSize" />
                                                                    </div>

                                                                    <div class="col-auto">
                                                                        <button id="btnSubmit" type="submit"
                                                                            class="btn btn-primary mb-3"
                                                                            disable>Create</button>
                                                                    </div>

                                                                    <div class="col-auto">
                                                                        <a href="/reset">
                                                                            <button id="btnReset" type="button"
                                                                                class="btn btn-danger mb-3"
                                                                                onclick="return confirm('Are you sure to reset game?')">Reset</button>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>


                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Game Message Section -->
                                <div class="col-xl-3 col-md-6 mb-4">
                                    <div class="card border-left-primary shadow h-100 py-2">
                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div
                                                        class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                        Turn</div>
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                        ${gameState.turn.name} ${gameState.turn.marker}
                                                    </div>
                                                </div>
                                                <div class="col-auto">
                                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="card-body">
                                            <div class="row no-gutters align-items-center">
                                                <div class="col mr-2">
                                                    <div
                                                        class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                        Game Message</div>
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                        ${gameState.gameStatus}</div>
                                                </div>
                                                <div class="col-auto">
                                                    <i class="fas fa-comments fa-2x text-gray-300"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Player Score -->
                                <div class="col-xl-3 col-md-6 mb-4">

                                    <div class="col-auto">
                                        <div class="card border-left-info shadow h-100 py-2">
                                            <div class="card-body">
                                                <div class="row no-gutters align-items-center">
                                                    <div class="col mr-2">
                                                        <div
                                                            class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                            Player 1</div>
                                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                            ${player1.score}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-auto">
                                        <div class="card border-left-info shadow h-100 py-2">
                                            <div class="card-body">
                                                <div class="row no-gutters align-items-center">
                                                    <div class="col mr-2">
                                                        <div
                                                            class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                            Player 2</div>
                                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                            ${player2.score}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <!-- CONTENT -->
                            <div class="row">

                                <!-- Board Section -->
                                <div class="col-xl-8 col-lg-7">
                                    <div class="card shadow mb-4">
                                        <!-- Card Header - Dropdown -->
                                        <div
                                            class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                            <h6 class="m-0 font-weight-bold text-primary">Board</h6>
                                        </div>
                                        <!-- Card Body -->
                                        <div class="card-body">

                                            <c:choose>
                                                <c:when test="${not empty board}">
                                                    <c:forEach items="${board.board}" begin="0" var="row" varStatus="r">
                                                        <c:forEach items="${row}" var="obj" varStatus="c">

                                                            <a href="/move?row=${r.index}&col=${c.index}">

                                                                <c:choose>
                                                                    <c:when test="${obj=='BLANK'}">
                                                                        <button type="button"
                                                                            class="btn btn-outline-primary piece"
                                                                            id="piece-${r.index}-${c.index}">
                                                                            ?
                                                                        </button>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <button type="button"
                                                                            class="btn btn-outline-primary piece"
                                                                            id="piece-${r.index}-${c.index}" disabled>
                                                                            ${obj}
                                                                        </button>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </a>

                                                        </c:forEach>
                                                        <br>
                                                    </c:forEach>
                                                </c:when>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>

                                <!-- Log Section -->
                                <div class="col-xl-4 col-lg-5">
                                    <div class="card shadow mb-4">
                                        <!-- Card Header - Dropdown -->
                                        <div
                                            class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                            <h6 class="m-0 font-weight-bold text-primary">Log Game</h6>
                                        </div>
                                        <!-- Card Body -->
                                        <div class="card-body">
                                            <c:forEach items="${gameState.turnMessage}" var="obj" varStatus="c">
                                                    ${obj}
                                                    <br>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </body>
        <script>
            var gameState = "${gameState}"
            if (gameState.length != 0) {
                document.getElementById("btnSubmit").disabled = 'true';
                document.getElementById("boardSize").disabled = 'true';
            }
        </script>

        </html>