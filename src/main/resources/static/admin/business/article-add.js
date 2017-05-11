$(function() {
    $('input[name="tags"]').tagator();

    var myEditormd = editormd("my-editormd", {
        width           : "100%",
        dialogMaskBgColor : "#000",
        height          : "600px",
        //autoHeight      : true,
        path            : "/editor.md-master/lib/",
        htmlDecode      : "style,script,iframe",
        imageUpload : true,
        imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        saveHTMLToTextarea : true,    // 保存 HTML 到 Textarea
        tocm            : true,         // Using [TOCM]
        tex             : true,
        emoji           : true,
        taskList        : true,
        flowChart       : true,
        sequenceDiagram : true,
        toolbar         : false
    });

    $(".cate-href").click(function() {
        var cateId = $(this).attr("cateId");
        var cateName = $(this).html();
        $('input[name="cateId"]').val(cateId);
        $('input[name="cateName"]').val(cateName);

        $(".cate-href").each(function() {
            if($(this).attr("class").indexOf("btn-info")>=0) {$(this).removeClass("btn-info");}
        });
        $(this).addClass("btn-info");
    });

    $("#dataForm").submit(function() {
        var title = $("input[name='title']").val();
        var cateId = $('input[name="cateId"]').val();
        if(title==null || $.trim(title)=='') {showDialog("请输入文章标题！"); return false;}
        else if(cateId==null || $.trim(cateId)=='') {showDialog("请选择文章所属分类！"); return false;}

        var content = myEditormd.getHTML();
        var mdCon = myEditormd.getMarkdown();
        if(content==null || $.trim(content)=='') {
            showDialog("请认真输入文章内容！"); return false;
        }

//        alert(myEditormd.getValue());

        $("textarea[name='content']").text(content);
        $("textarea[name='mdContent']").text(mdCon);

        return true;
    });
});