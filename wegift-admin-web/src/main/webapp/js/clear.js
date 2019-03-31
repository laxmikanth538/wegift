function clear() {
	var errors = document.querySelectorAll("p");
	for (var i = 0; i < errors.length; i++) {
		if (errors[i].value != "" && errors[i].id.endsWith("error")) {
			document.getElementById(errors[i].id).innerHTML = "";
		}
	}
}