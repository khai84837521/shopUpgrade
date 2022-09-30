(function (Handlebars) {
	
	Handlebars.registerHelper("json", function (obj) {
		try {
			return JSON.stringify(obj);
		}
		catch (e) {
			return '';
		}
	});

	Handlebars.registerHelper("priceFormat", function (number) {
		var parts = number.toString().split('.');
		parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		return parts.join('.');
	});

	Handlebars.registerHelper("eq", function (a, b, options) {
		return (a == b) ? options.fn(this) : options.inverse(this);
	});

	Handlebars.registerHelper("ne", function (a, b, options) {
		return (a != b) ? options.fn(this) : options.inverse(this);
	});

	Handlebars.registerHelper("gt", function (a, b, options) {
		return (a > b) ? options.fn(this) : options.inverse(this);
	});

	Handlebars.registerHelper("gte", function (a, b, options) {
		return (a >= b) ? options.fn(this) : options.inverse(this);
	});

	Handlebars.registerHelper("lt", function (a, b, options) {
		return (a < b) ? options.fn(this) : options.inverse(this);
	});

	Handlebars.registerHelper("lte", function (a, b, options) {
		return (a <= b) ? options.fn(this) : options.inverse(this);
	});

	Handlebars.registerHelper("embedded", function(value){
		return value;
	});	
	
}) (Handlebars || {});