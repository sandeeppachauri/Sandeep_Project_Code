$.subscribe('beforeFirstAccordian', function(event,data)
        {
          setTimeout(function(){ $("#foldeffect1").fadeIn(); }, 10);
          setTimeout(function(){ $("#foldeffect1").fadeOut(); }, 4000);
        });

$.subscribe('beforeSecondAccordian', function(event,data)
        {
          setTimeout(function(){ $("#foldeffect2").fadeIn(); }, 10);
          setTimeout(function(){ $("#foldeffect2").fadeOut(); }, 4000);
        });

$.subscribe('beforeThirdAccordian', function(event,data)
        {
          setTimeout(function(){ $("#foldeffect3").fadeIn(); }, 10);
          setTimeout(function(){ $("#foldeffect3").fadeOut(); }, 4000);
        });