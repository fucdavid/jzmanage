$(function() {
	loginInfo();
	// 菜单侧栏
	$('body').on('tap', '.hk-home-btn', function() {
		if (!$('.hk-main').hasClass('translateX')) {
			// 设置页面最小高度
			$('.hk-main').css('min-height', function() {
				return $(window).height();
			});
			$('.hk-home').after('<div class="mask"></div>');
			$('.hk-main,.hk-home').addClass('translateX');
		} else {
			$('.hk-main,.hk-home').removeClass('translateX');
			$('.mask').remove();
		}
	});
	$('body').on('click', '.mask', function() {
		$('.hk-main,.hk-home').removeClass('translateX');
		$('.mask').remove();
	});
	// 页内切换
	$('.slide-page-btn').on('click', function(e) {
		var thisPage = $(this).parents('.slide-page');
		var nextPage = $('#' + $(this).attr('data-slide'));
		sliderNextPage(thisPage, nextPage);
		e.stopPropagation();
		return false;
	});
	$('.slide-back-btn').on('click', function(e) {
		var thisPage = $(this).parents('.slide-page');
		var backPage = $('#' + $(this).attr('data-slide'));
		sliderBackPage(thisPage, backPage);
		e.stopPropagation();
		return false;
	});
	// 返回按钮
	$('.back-btn').on("click", function() {
		var url = $(this).attr('data-url');
		var referrer = document.referrer;
		if (referrer == url || !url) {
			history.go(-1);
		} else {
			window.location.href = url;
		}
	});
	// 手风琴块展开
	$('.wrapper .b li label:not(.disable)').click(function() {
		$(this).next('div').toggle();
		if ($(this).next().is("div")) {
			$(this).children('.icon').toggleClass('active');
		}
	});
});
function infoPrompt(text, time) {
	if (!$('.prompt-wrap').length) {
		var html = '<div class="prompt-wrap"><div class="prompt-wrapper"><div class="prompt-message"><i class="icon info"></i><span class="prompt-text">微信授权登陆成功</span></div></div></div>';
		$('body').prepend(html);
	}
	$('.prompt-wrap .prompt-text').text(text);
	$('.prompt-wrap').show();
	var t = 3000;
	if (time) {
		t = time;
	}
	setTimeout(function() {
		$('.prompt-wrap').hide(600);
	}, t);
}

/**
 * 判断是否微信内置浏览器
 */
function isWeixin() {
	var ua = navigator.userAgent.toLowerCase();
	if (ua.match(/microMessenger/i) == "micromessenger") {
		return true;
	} else {
		return false;
	}
}

/**
 * 内页切换,下一页
 */
function sliderNextPage(thisPage, nextPage) {
	$('.hk-main').css('min-height', function() {
		return $(window).height();
	});
	thisPage.css({
		'position' : 'absolute',
		'left' : '-100%'
	});
	nextPage.css({
		'position' : 'relative',
		'left' : '0'
	});
}

/**
 * 内页切换 ,返回上一页
 */
function sliderBackPage(thisPage, backPage) {
	$('.hk-main').css('min-height', function() {
		return $(window).height();
	});
	thisPage.css({
		'position' : 'absolute',
		'left' : '100%'
	});
	backPage.css({
		'position' : 'relative',
		'left' : '0'
	});
}

/**
 * 头部登录信息设置
 */
function loginInfo() {
	// 异步请求登陆信息
	isLogin = false;
	$
			.post(
					_webApp + "/login/loginInfo",
					function(result) {
						if (result.isLogin == true) {
							$("#loginInfo img").attr('src',
									_webApp + '/images/page/user-pic.png');
							$("#loginInfo p").html(
									'<a>' + result.userName + '</a>');
							$("#loginInfo a").attr('href',
									_webApp + '/user/center');
							$("#cmenu")
									.append(
											'<li><a href="'
													+ _webApp
													+ '/login/logout"><i class="icon power"></i>退出登录</a></li>');
							isLogin = true;
						} else {
							isLogin = false;
						}
					}, "json");
}

/**
 * 格式价格
 */
function currencyFormatted(amount) {
	var i = parseFloat(amount);
	var minus = '';
	if (i < 0) {
		minus = '-';
	}
	i = Math.abs(i);
	i = parseInt((i + .005) * 100);
	i = i / 100;
	s = new String(i);
	if (s.indexOf('.') < 0) {
		s += '.00';
	}
	if (s.indexOf('.') == (s.length - 2)) {
		s += '0';
	}
	s = minus + s;
	return s;
}

/**
 * 去空格
 */
String.prototype.trim = function() {
	return this.replace(/^\s*(\S*(?:\s \S )*)\s*$/, '$1');
};
/**
 * 时间格式化
 * 
 * @param {Object}
 *            fmt
 */
Date.prototype.format = function(fmt) {
	return dateFormat(this, fmt);
};

function dateFormat(date, format) {
	date = new Date(date);
	var map = {
		"M" : date.getMonth() + 1, // 月份
		"d" : date.getDate(), // 日
		"h" : date.getHours(), // 小时
		"m" : date.getMinutes(), // 分
		"s" : date.getSeconds(), // 秒
		"q" : Math.floor((date.getMonth() + 3) / 3), // 季度
		"S" : date.getMilliseconds()
	// 毫秒
	};
	format = format.replace(/([yMdhmsqS])+/g, function(all, t) {
		var v = map[t];
		if (v !== undefined) {
			if (all.length > 1) {
				v = '0' + v;
				v = v.substr(v.length - 2);
			}
			return v;
		} else if (t === 'y') {
			return (date.getFullYear() + '').substr(4 - all.length);
		}
		return all;
	});
	return format;
}
/**
 * Simple Map
 * 
 * 
 * var m = new Map(); m.put('key','value'); ... var s = "";
 * m.each(function(key,value,index){ s += index+":"+ key+"="+value+"/n"; });
 * alert(s);
 * 
 * @author dewitt
 * @date 2008-05-24
 */
function Map() {
	/** 存放键的数组(遍历用到) */
	this.keys = new Array();
	/** 存放数据 */
	this.data = new Object();

	/**
	 * 放入一个键值对
	 * 
	 * @param {String}
	 *            key
	 * @param {Object}
	 *            value
	 */
	this.put = function(key, value) {
		if (this.data[key] == null) {
			this.keys.push(key);
		}
		this.data[key] = value;
	};

	/**
	 * 获取某键对应的值
	 * 
	 * @param {String}
	 *            key
	 * @return {Object} value
	 */
	this.get = function(key) {
		return this.data[key];
	};

	/**
	 * 删除一个键值对
	 * 
	 * @param {String}
	 *            key
	 */
	this.remove = function(key) {
		this.keys.remove(key);
		this.data[key] = null;
	};

	/**
	 * 遍历Map,执行处理函数
	 * 
	 * @param {Function}
	 *            回调函数 function(key,value,index){..}
	 */
	this.each = function(fn) {
		if (typeof fn != 'function') {
			return;
		}
		var len = this.keys.length;
		for (var i = 0; i < len; i++) {
			var k = this.keys[i];
			fn(k, this.data[k], i);
		}
	};

	/**
	 * 获取键值数组(类似Java的entrySet())
	 * 
	 * @return 键值对象{key,value}的数组
	 */
	this.entrys = function() {
		var len = this.keys.length;
		var entrys = new Array(len);
		for (var i = 0; i < len; i++) {
			entrys[i] = {
				key : this.keys[i],
				value : this.data[i]
			};
		}
		return entrys;
	};

	/**
	 * 判断Map是否为空
	 */
	this.isEmpty = function() {
		return this.keys.length == 0;
	};

	/**
	 * 获取键值对数量
	 */
	this.size = function() {
		return this.keys.length;
	};

	/**
	 * 重写toString
	 */
	this.toString = function() {
		var s = "{";
		for (var i = 0; i < this.keys.length; i++, s += ',') {
			var k = this.keys[i];
			s += k + "=" + this.data[k];
		}
		s += "}";
		return s;
	};
}