var xht = new XMLHttpRequest();
xht.onreadystatechange = function(){
    if (this.readyState == 4 && this.status == 200) {
        var responseJSON = this.responseText
        console.log(responseJSON)
    }
}
xht.open("GET","/rest/books",true);
xht.send()