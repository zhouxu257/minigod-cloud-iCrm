<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>新增银行卡信息页</title>
    <%@include file="/common/commonCSS.jsp" %>
    <%@include file="/common/commonJS.jsp" %>
    <%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
    <%--<link rel="stylesheet" href="${webRoot}/viewer/css/viewer.css">--%>
    <%--<link rel="stylesheet" href="${webRoot}/viewer/css/main.css">--%>
    <%--<script src="${webRoot}/viewer/js/viewer.js"></script>--%>
    <%--<script src="${webRoot}/viewer/js/main.js"></script>--%>
</head>
<body>
<div v-show="!showList" class="panel panel-default">
    <div class="panel-heading"><b style="color: #368763;text-align:center">银行卡信息</b></div>
    </br>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">客户账号</label>
            <div class="col-xs-9">
               <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="clientId" name="clientId" type="text" class="form-control">
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">资金账号</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="fundAccount" name="fundAccount" type="text" class="form-control">
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">银行卡类型</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                <tag:select id="bankType" name="bankType" nameKey="FUND_BANK_TYPE"
                            isAddDefaltOption="false" clazz="form-control" initDidableKey="7"/>
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">银行名称</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="bankName" name="bankName" type="text" class="form-control">
                </span>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">银行账户名称</label>
            <div class="col-xs-9">
                <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="bankAccount" name="bankAccount" type="text" class="form-control">
                </span>
            </div>
        </div>

        <div class="form-group col-sm-6 col-md-6">
            <label class="col-sm-3 control-label no-padding-right">银行账户号码</label>
            <div class="col-xs-9">
                 <span class="col-sm-12 block input-icon input-icon-right">
                    <input id="bankNo" name="bankNo" type="text" class="form-control">
                </span>
            </div>
        </div>
    </div>

    <div class="row" style="margin-left: 40%;padding-bottom: 28px;margin-top: 15px;">
        <button class="layui-btn " type="button" onclick="save()">保存</button>
        <button class="layui-btn layui-btn-primary" type="button" onclick="closeThisWindow()">关 闭</button>
    </div>
</div>

</body>
<script>
    // 新增信息
    function save() {
        confirm("确定执行此操作吗？", function () {
            var url = "${webRoot}/clientBankCardInfo/save";
            var params = {
                'fundAccount':$("#fundAccount").val(),
                'clientId':$("#clientId").val(),
                'bankType':$("#bankType").val(),
                'bankName': $("#bankName").val(),
                'bankAccount': $("#bankAccount").val(),
                'bankNo': $("#bankNo").val()
            };
            $.post(url, params, function (result) {
                if (result.code == '0') {
                    toast(result, function () {
                        //刷新父窗口列表
                        parent.location.reload();
                        //关闭弹框
                        closeThisWindow();
                    })
                } else {
                    alertMsg(result.msg);
                }
            }, "json");

        });
    }

</script>

</html>