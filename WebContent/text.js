(function(c) {
	var b = (function() {
		var g = {};
		var f = null;
		var j = {
			currencySymbol : "$",
			classCartIcon : "my-cart-icon",
			classCartBadge : "my-cart-badge",
			classProductQuantity : "my-product-quantity",
			classProductRemove : "my-product-remove",
			classCheckoutCart : "my-cart-checkout",
			affixCartIcon : true,
			showCheckoutModal : true,
			numberOfDecimals : 2,
			cartItems : null,
			clickOnAddToCart : function(k) {
			},
			afterAddOnCart : function(l, k, m) {
			},
			clickOnCartIcon : function(l, m, k, n) {
			},
			checkoutCart : function(l, k, m) {
			},
			getDiscountPrice : function(l, k, m) {
				return null
			}
		};
		var i = function(k) {
			f = c.extend({}, j);
			if (typeof k === "object") {
				c.extend(f, k)
			}
		};
		var h = function() {
			return f
		};
		g.loadOptions = i;
		g.getOptions = h;
		return g
	}());
	var e = (function() {
		var f = {};
		var g = function(i) {
			if (isNaN(i)) {
				throw new Error("Parameter is not a Number")
			}
			i = i * 1;
			var h = b.getOptions();
			return i.toFixed(h.numberOfDecimals)
		};
		f.getRoundedNumber = g;
		return f
	}());
	var d = (function() {
		var i = {};
		localStorage.products = localStorage.products ? localStorage.products
				: "";
		var o = function(s) {
			var q = -1;
			var r = f();
			c.each(r, function(t, u) {
				if (u.id == s) {
					q = t;
					return
				}
			});
			return q
		};
		var n = function(q) {
			localStorage.products = JSON.stringify(q)
		};
		var k = function(w, r, q, s, v, u) {
			var t = f();
			t.push({
				id : w,
				name : r,
				summary : q,
				price : s,
				quantity : v,
				image : u
			});
			n(t)
		};
		var f = function() {
			try {
				var r = JSON.parse(localStorage.products);
				return r
			} catch (q) {
				return []
			}
		};
		var p = function(t, s) {
			var q = o(t);
			if (q < 0) {
				return false
			}
			var r = f();
			r[q].quantity = typeof s === "undefined" ? r[q].quantity * 1 + 1
					: s;
			n(r);
			return true
		};
		var l = function(v, r, q, s, u, t) {
			if (typeof v === "undefined") {
				console.error("id required");
				return false
			}
			if (typeof r === "undefined") {
				console.error("name required");
				return false
			}
			if (typeof t === "undefined") {
				console.error("image required");
				return false
			}
			if (!c.isNumeric(s)) {
				console.error("price is not a number");
				return false
			}
			if (!c.isNumeric(u)) {
				console.error("quantity is not a number");
				return false
			}
			q = typeof q === "undefined" ? "" : q;
			if (!p(v)) {
				k(v, r, q, s, u, t)
			}
		};
		var m = function() {
			n([])
		};
		var j = function(r) {
			var q = f();
			q = c.grep(q, function(t, s) {
				return t.id != r
			});
			n(q)
		};
		var h = function() {
			var q = 0;
			var r = f();
			c.each(r, function(s, t) {
				q += t.quantity * 1
			});
			return q
		};
		var g = function() {
			var r = f();
			var q = 0;
			c.each(r, function(s, t) {
				q += t.quantity * t.price;
				q = e.getRoundedNumber(q) * 1
			});
			return q
		};
		i.getAllProducts = f;
		i.updatePoduct = p;
		i.setProduct = l;
		i.clearProduct = m;
		i.removeProduct = j;
		i.getTotalQuantity = h;
		i.getTotalPrice = g;
		return i
	}());
	var a = function(j) {
		var i = b.getOptions();
		var r = c("." + i.classCartIcon);
		var p = c("." + i.classCartBadge);
		var v = i.classProductQuantity;
		var h = i.classProductRemove;
		var q = i.classCheckoutCart;
		var t = "my-cart-modal";
		var u = "my-cart-table";
		var f = "my-cart-grand-total";
		var x = "my-cart-empty-message";
		var w = "my-cart-discount-price";
		var g = "my-product-total";
		var o = "my-cart-icon-affix";
		if (i.cartItems && i.cartItems.constructor === Array) {
			d.clearProduct();
			c.each(i.cartItems, function() {
				d.setProduct(this.id, this.name, this.summary, this.price,
						this.quantity, this.image)
			})
		}
		p.text(d.getTotalQuantity());
		if (!c("#" + t).length) {
			c("body")
					.append(
							'<div class="modal fade" id="'
									+ t
									+ '" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"><div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button><h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-shopping-cart"></span> My Cart</h4></div><div class="modal-body"><table class="table table-hover table-responsive" id="'
									+ u
									+ '"></table></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button><button type="button" class="btn btn-primary '
									+ q
									+ '">Checkout</button></div></div></div></div>')
		}
		var z = function() {
			var A = c("#" + u);
			A.empty();
			var C = d.getAllProducts();
			c
					.each(
							C,
							function() {
								var D = this.quantity * this.price;
								A
										.append('<tr title="'
												+ this.summary
												+ '" data-id="'
												+ this.id
												+ '" data-price="'
												+ this.price
												+ '"><td class="text-center" style="width: 30px;"><img width="30px" height="30px" src="'
												+ this.image
												+ '"/></td><td>'
												+ this.name
												+ '</td><td title="Unit Price">'
												+ i.currencySymbol
												+ e
														.getRoundedNumber(this.price)
												+ '</td><td title="Quantity"><input type="number" min="1" style="width: 70px;" class="'
												+ v
												+ '" value="'
												+ this.quantity
												+ '"/></td><td title="Total" class="'
												+ g
												+ '">'
												+ i.currencySymbol
												+ e.getRoundedNumber(D)
												+ '</td><td title="Remove from Cart" class="text-center" style="width: 30px;"><a href="javascript:void(0);" class="btn btn-xs btn-danger '
												+ h + '">X</a></td></tr>')
							});
			A
					.append(C.length ? '<tr><td></td><td><strong>Total</strong></td><td></td><td></td><td><strong id="'
							+ f + '"></strong></td><td></td></tr>'
							: '<div class="alert alert-danger" role="alert" id="'
									+ x + '">Your cart is empty</div>');
			var B = i.getDiscountPrice(C, d.getTotalPrice(), d
					.getTotalQuantity());
			if (C.length && B !== null) {
				A
						.append('<tr style="color: red"><td></td><td><strong>Total (including discount)</strong></td><td></td><td></td><td><strong id="'
								+ w + '"></strong></td><td></td></tr>')
			}
			s();
			n()
		};
		var l = function() {
			z();
			c("#" + t).modal("show")
		};
		var y = function() {
			c.each(c("." + v), function() {
				var A = c(this).closest("tr").data("id");
				d.updatePoduct(A, c(this).val())
			})
		};
		var s = function() {
			c("#" + f).text(
					i.currencySymbol + e.getRoundedNumber(d.getTotalPrice()))
		};
		var n = function() {
			c("#" + w).text(
					i.currencySymbol
							+ e.getRoundedNumber(i.getDiscountPrice(d
									.getAllProducts(), d.getTotalPrice(), d
									.getTotalQuantity())))
		};
		if (i.affixCartIcon) {
			var k = r.offset().top * 1 + r.css("height").match(/\d+/) * 1;
			var m = r.css("position");
			c(window).scroll(function() {
				c(window).scrollTop() >= k ? r.addClass(o) : r.removeClass(o)
			})
		}
		r.click(function() {
			i.showCheckoutModal ? l() : i
					.clickOnCartIcon(r, d.getAllProducts(), d.getTotalPrice(),
							d.getTotalQuantity())
		});
		c(document).on(
				"input",
				"." + v,
				function() {
					var A = c(this).closest("tr").data("price");
					var C = c(this).closest("tr").data("id");
					var B = c(this).val();
					c(this).parent("td").next("." + g).text(
							i.currencySymbol + e.getRoundedNumber(A * B));
					d.updatePoduct(C, B);
					p.text(d.getTotalQuantity());
					s();
					n()
				});
		c(document).on("keypress", "." + v, function(A) {
			if (A.keyCode == 38 || A.keyCode == 40) {
				return
			}
			A.preventDefault()
		});
		c(document).on("click", "." + h, function() {
			var A = c(this).closest("tr");
			var B = A.data("id");
			A.hide(500, function() {
				d.removeProduct(B);
				z();
				p.text(d.getTotalQuantity())
			})
		});
		c(document).on(
				"click",
				"." + q,
				function() {
					var A = d.getAllProducts();
					if (!A.length) {
						c("#" + x).fadeTo("fast", 0.5).fadeTo("fast", 1);
						return
					}
					y();
					i.checkoutCart(d.getAllProducts(), d.getTotalPrice(), d
							.getTotalQuantity());
					d.clearProduct();
					p.text(d.getTotalQuantity());
					c("#" + t).modal("hide")
				});
		c(document).on(
				"click",
				j,
				function() {
					var A = c(this);
					i.clickOnAddToCart(A);
					var G = A.data("id");
					var C = A.data("name");
					var B = A.data("summary");
					var D = A.data("price");
					var F = A.data("quantity");
					var E = A.data("image");
					d.setProduct(G, C, B, D, F, E);
					p.text(d.getTotalQuantity());
					i.afterAddOnCart(d.getAllProducts(), d.getTotalPrice(), d
							.getTotalQuantity())
				})
	};
	c.fn.myCart = function(f) {
		b.loadOptions(f);
		a(this.selector);
		return this
	}
})(jQuery);