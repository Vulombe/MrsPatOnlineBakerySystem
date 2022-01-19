/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('.add-to-cart').on('click', function () {
        var cart = $('.shopping-cart');
        var imgtodrag = $(this).parent('.item').find("img").eq(0);
        if (imgtodrag) {
            var imgclone = imgtodrag.clone()
                .offset({
                top: imgtodrag.offset().top,
                left: imgtodrag.offset().left
            })
                .css({
                'opacity': '0.5',
                    'position': 'absolute',
                    'height': '150px',
                    'width': '150px',
                    'z-index': '100'
            })
                .appendTo($('body'))
                .animate({
                'top': cart.offset().top + 10,
                    'left': cart.offset().left + 10,
                    'width': 75,
                    'height': 75
            }, 1000, 'easeInOutExpo');
            
            setTimeout(function () {
                cart.effect("shake", {
                    times: 2
                }, 200);
            }, 1500);

            imgclone.animate({
                'width':75,
                    'height':75
            }, function () {
                $(this).detach()
            });
        }
    });
    //// back and forward button
function goBack() {
	window.history.back();
	console.log('We are in previous page');
}

function goForward() {
	window.history.back();
	console.log('We are in next page');
}

