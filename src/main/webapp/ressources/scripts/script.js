function modifierTshirt(event) {
	document.getElementsByTagName('dialog')[0].setAttribute('open', '');
	document.querySelector('dialog');
}

function fermerMessage(event) {
	document.getElementsByTagName('dialog')[0].removeAttribute('open');
	console.log(event);
}