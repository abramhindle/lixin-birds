s.options.numBuffers = 16000;
s.boot;

s.waitForBoot {
    
    // Hilbert stuff
    
    ~rot = {|n,x,y,rx,ry|
    	var t;
        if(ry == 0,{
            if(rx == 1, {
                x = (n-1) - x;
                y = (n-1) - y;
            });
    		t = y;
    		y = x;
    		x = t;
        });
    	[x,y];
    };
    
    ~xy2d = {|n,x,y| 
    	var rx = 0, ry = 0, s = 0, d =0,v;
    	n = n.asInteger;
    	s = n.div(2).asInteger;
    	x = x.asInteger;
    	y = y.asInteger;
    	while({s > 0},
    		{
    			rx = ((x & s) > 0).asInteger;
    			ry = ((y & s) > 0).asInteger;
    			d = (d + (s * s * ((3 * rx).asInteger().bitXor(ry)))).asInteger;
    			//[s,rx,ry,d].postln;		
    			v = ~rot.(s, x, y, rx, ry);
    			x = v[0].asInteger;
    			y = v[1].asInteger;
    			s = s.div(2).asInteger;
    		});
    	d;
    };
    ~hilbert = {arg x,y,n=64;
    	~xy2d.(n,x*(n-1),y*(n-1))/(n*n - 1)
    };
    [
    	~hilbert.(1,1),
    	~hilbert.(1,0.01),
    	~hilbert.(0,1),
    	~hilbert.(1,0),
    	~hilbert.(1,1),
    	~hilbert.(1,1)
    ];
    
    // s: 4 rx: 1 ry: 0 d: 48
    // s: 2 rx: 1 ry: 0 d: 60
    // s: 1 rx: 1 ry: 0 d: 63
    // xy2d(8,7,0) = 63
    [
    ~xy2d.(8,0,0) == 0,
    ~xy2d.(8,0,1) == 1,
    ~xy2d.(8,0,2) == 14,
    ~xy2d.(8,0,3) == 15,
    ~xy2d.(8,0,4) == 16,
    ~xy2d.(8,0,5) == 19,
    ~xy2d.(8,0,6) == 20,
    ~xy2d.(8,0,7) == 21,
    ~xy2d.(8,1,0) == 3,
    ~xy2d.(8,1,2) == 13,
    ~xy2d.(8,1,3) == 12,
    ~xy2d.(8,1,4) == 17,
    ~xy2d.(8,1,5) == 18,
    ~xy2d.(8,1,6) == 23,
    ~xy2d.(8,1,7) == 22,
    ~xy2d.(8,7,0) == 63,
    ~xy2d.(8,7,7) == 42,
    ~xy2d.(32,31,31) == 682	
    ];
    
    [
    	~xy2d.(8,0,0) ,
    	~xy2d.(8,0,1) ,
    	~xy2d.(8,0,2) ,
    	~xy2d.(8,0,3) ,
    	~xy2d.(8,7,7)
    ];
    
    
    // Boot the server
    
    // Load an audio file
    
    
    ~buffers = [
    "samples/116820__inchadney__morning-in-the-forest001.wav",
    "samples/116820__inchadney__morning-in-the-forest002.wav",
    "samples/116820__inchadney__morning-in-the-forest003.wav",
    "samples/116820__inchadney__morning-in-the-forest004.wav",
    "samples/116820__inchadney__morning-in-the-forest005.wav",
    "samples/116820__inchadney__morning-in-the-forest006.wav",
    "samples/116820__inchadney__morning-in-the-forest007.wav",
    "samples/116820__inchadney__morning-in-the-forest008.wav",
    "samples/116820__inchadney__morning-in-the-forest009.wav",
    "samples/116820__inchadney__morning-in-the-forest010.wav",
    "samples/116820__inchadney__morning-in-the-forest011.wav",
    "samples/116820__inchadney__morning-in-the-forest012.wav",
    "samples/116820__inchadney__morning-in-the-forest013.wav",
    "samples/116820__inchadney__morning-in-the-forest014.wav",
    "samples/147582__kangaroovindaloo__fryers-forest-dawn-long-version-01.wav.mono.wav",
    "samples/147582__kangaroovindaloo__fryers-forest-dawn-long-version-02.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn001.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn002.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn003.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn004.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn005.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn006.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn007.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn008.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn009.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn010.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-01.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-02.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-03.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-04.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-05.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-06.wav.mono.wav",
    "samples/204804__kangaroovindaloo__tenzin-s-dawn-07.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226009.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226010.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226011.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226012.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226013.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-01.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-02.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-03.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-04.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-05.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-06.wav.mono.wav",
    "samples/238592__klankbeeld__hamlet-in-may-haanwijk-nl-long-140519-0226-07.wav.mono.wav",
    "samples/348510__marlo1981__country-side-night-ambience-01.wav.mono.wav",
    "samples/348510__marlo1981__country-side-night-ambience-02.wav.mono.wav",
    "samples/348510__marlo1981__country-side-night-ambience-03.wav.mono.wav",
    "samples/birds001.wav",
    "samples/birds002.wav",
    "samples/birds003.wav",
    "samples/birds004.wav",
    "samples/india-bird-reverb-clean-old1.wav",
    "samples/india-bird-reverb-clean.wav"
    ].collect({|x| Buffer.read(s,x) });
    
    ~buffers.choose.bufnum;
    ~buff  = ~buffers[0];
    ~buff2 = ~buffers[1];
    ~buff3 = ~buffers[2];
    ~buff4  = ~buffers[3];
    
    b = ~buff.bufnum;
    ~b2 =~buff2.bufnum;
    ~b3 =~buff3.bufnum;
    ~b4 =~buff4.bufnum;
    
    s.sync;
    	
    SynthDef(\g1rainer,
    	{
    		arg trate,d,b,rate=1.2,amp=1.0,out=0;
    		var dur;
    		dur = (10.rand + 1.0) / (2*trate);
    		Out.ar(out,
    			TGrains.ar(2,
    				Impulse.ar(trate), // trigger
    				b, // buffer
    				(rate ** WhiteNoise.kr(3).round(1)), // rate
    				1.0.rand + d*BufDur.kr(b), //center
    				//d*BufDur.kr(b),
    				dur, //duration
    				WhiteNoise.kr(0.6),//pan
    				0.1*amp, //amp
    				2
    			);
    		);
    	}).load;
    
    	s.sync;
    	
    // play the synth
    x = Synth(\g1rainer,[\rate,2,\d,0.5,\b,b]);
    x.set(\d,0.2);
    x.set(\b,b);
    ~xd = Bus.control(s);
    x.map(\d,~xd);
    ~xd.set(0.1);
    
    y = Synth(\g1rainer,[\trate,2,\d,0.5,\b,~buff4]);
    y.map(\d,~xd);
    z = Synth(\g1rainer,[\trate,2,\d,0.5,\b,~buff3]);
    z.map(\d,~xd);
    u = Synth(\g1rainer,[\trate,2,\d,0.5,\b,~buff2]);
    u.map(\d,~xd);
    
    ~randr = {|v|
    	v.set(\rate,0.5.rand + 0.9);//1.001);//0.4.rand + 1.0);
    	v.set(\trate,5.0.linrand + 0.1);//1.9.rand + 0.4);
    	v.set(\b,~buffers.choose.bufnum);
    	v.set(\amp,4.0.linrand);
    };
    ~randr.(x);
    ~randr.(y);
    ~randr.(z);
    ~randr.(u);
    
    // xy coords and buses for x and y coords
    ~xm = 0;
    ~ym = 0;
    ~xmb = Bus.control(s);
    ~ymb = Bus.control(s);
    ~amp = Bus.control(s);
    ~amp.set(1.0);
    
    ~xhandler = {|msg|
    	var x = msg[1];
    	~xm = x;
    	~d = ~hilbert.(~xm,~ym,n=256);
    	~d.postln;
    	~xd.set(~d);
    	~amp.set(1.0);
    };
    
    ~yhandler = {|msg|
    	var y = msg[1];
    	~ym = y;
    	~d = ~hilbert.(~xm,~ym,n=256);
    	~d.postln;
    	~xd.set(~d);
    	~amp.set(1.0);
    };
    
    
    OSCFunc.newMatching(~xhandler, '/1/x');
    OSCFunc.newMatching(~yhandler, '/1/y');
    
    ~randr.(x);
    ~randr.(y);
    ~randr.(z);
    ~randr.(u);
    
    ~randrout = Routine({
    	while(true,{
    		"Choosing".postln;
    		~randr.([x,y,z,u].choose);
    		60.0.linrand.wait;
    	});
    }).play;
    //~randrout.stop
    
    
    ~randwalk = Routine({
    	var mx = 1.0.rand, my = 1.0.rand, ms=0.015;
    	while(true,{
    		mx = max(0.0,min(1.0,ms.rand - (ms/2) + mx));
    		my = max(0.0,min(1.0,ms.rand - (ms/2) + my));
    		[mx,my].postln;
    		~xhandler.(["",mx]);
    		~yhandler.(["",my]);
    		5.0.rand.wait;
    	});
    }).play;
    //~randwalk.stop
    
};