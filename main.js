// Get a reference to the button element
    var button = document.getElementById("submit");
    var textToSave = "";
    var filename = "formResults.txt";
    // Add an onclick event to the button
    button.addEventListener("click", function(){
        for(let i = 0; i < 99999;i++){
            let temp = document.getElementById(i.toString());
            if(temp == null) break;
            if(temp.value == "on"){
                console.log(temp.checked)
                textToSave += temp.checked + "\n";
            }
            else {
                console.log(temp.value);
                textToSave += temp.value + "\n";
            }

            
            
            
                      
        }
        var blob = new Blob([textToSave], { type: "text/plain;charset=utf-8" });
        saveAs(blob, filename);

    });