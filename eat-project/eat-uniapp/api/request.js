const url_all = {
	'DEV': 'http://10.4.27.70:1000',
	'BUILD': 'http://10.4.27.70:1000'
}

function service(options = {}) {

	options.url = `${url_all.DEV}${options.url}`;

	let token = ""
	try {
		const value = uni.getStorageSync('token');

		if (value) {
			console.log(value);
			token = value
		}

	} catch (e) {

		// error
	};

	console.log('Token:', token);
	options.header = {
		'token': token
	};

	return new Promise((resolved, rejected) => {
		options.success = (response) => {
			let res = response.data
			console.log(res.code)
			if (res.code === 200) {
				resolved(res);
			} else if (res.code === 500) {
				uni.showToast({
					title: res.msg,
					duration: 2000,
					icon: 'none'
				});
			} else {
				if (res.msg != null) {
					uni.showToast({
						title: res.msg,
						duration: 2000,
						icon: 'none'
					});

					uni.navigateTo({
						url: "/pages/login/login"
					})

				}
				console.log(res)
				rejected(res);
			}
		}

		options.fail = (err) => {
			rejected(err)
		}
		uni.request(options);

	});
}

export default service;