$("#register-form").submit(function(){
    var isFormValid = true;

    $(".required input").each(function(){
        if ($.trim($(this).val()).length == 0){
            $(this).addClass("highlight");
            isFormValid = false;
        }
        else{
            $(this).removeClass("highlight");
        }
    });

    if (!isFormValid) alert("Please fill in all the required fields (indicated by *)");

    return isFormValid;
});

$(document).ready(function() {
    $('#rangeForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            date: {
                validators: {
                    date: {
                        message: 'The date is not valid',
                        format: 'YYYY-MM-DD',
                        // min and max options can be strings or Date objects
                        min: '1500-01-01',
                        max: '2020-12-30'
                    }
                }
            }
        }
    });
});


