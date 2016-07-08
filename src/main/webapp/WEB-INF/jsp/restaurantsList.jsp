<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.11/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="webjars/datetimepicker/2.4.7/jquery.datetimepicker.css">

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><spring:message code="restaurants.title"/></h3>

            <div class="view-box">
                <%--TODO:<form:form method="post" class="form-horizontal" role="form" id="filter">--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-sm-2" for="startDate">From Date:</label>--%>

                        <%--<div class="col-sm-2">--%>
                            <%--<input class="form-control" name="startDate" id="startDate">--%>
                        <%--</div>--%>

                        <%--<label class="control-label col-sm-2" for="endDate">To Date:</label>--%>

                        <%--<div class="col-sm-2">--%>
                            <%--<input class="form-control" name="endDate" id="endDate">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-sm-2" for="startTime">From Time:</label>--%>

                        <%--<div class="col-sm-2">--%>
                            <%--<input class="form-control time-picker" name="startTime" id="startTime">--%>
                        <%--</div>--%>

                        <%--<label class="control-label col-sm-2" for="endTime">To Time:</label>--%>

                        <%--<div class="col-sm-2">--%>
                            <%--<input class="form-control time-picker" name="endTime" id="endTime">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-sm-8">--%>
                            <%--<button type="submit" class="btn btn-primary pull-right">Filter</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form:form>--%>
                <a class="btn btn-sm btn-info" onclick="add()"><spring:message code="restaurants.add"/></a>
                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Votes</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title"><spring:message code="restaurants.edit"/></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="votes" class="control-label col-xs-3">Votes</label>

                        <div class="col-xs-9">
                            <input type="number" class="form-control" id="votes" name="votes"
                                   placeholder="2000">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<%--TODO:delete button--%>
</body>
<script type="text/javascript" src="webjars/datetimepicker/2.4.7/build/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="resources/js/restaurantsDatatables.js"></script>
</html>