`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 08:41:43 PM
// Design Name: 
// Module Name: Task2_tb
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module Task2_tb(

    );
        reg e;
        reg s;
        reg r;
        wire q;
        wire notQ;
        
        Task2 DUT (.e(e), .s(s), .r(r), .q(q), .notQ(notQ));
        
        initial begin
        #100 $finish; //runs simulation 100 times
        end
        
        initial begin
        s = 0;
        r = 0;
        e = 0;
        #10 //10 
        s = 1;
        #10 //20
        e = 1;
        #10 //30
        s = 0;
        #10 //40
        r = 1;
        #10 //50
        e = 0;
        #10 //60
        s = 1;
        r = 0;
        #10 //70
        r = 1;
        s = 0;
        #10 //80
        s = 1;
        r = 0;
        
        
        end
endmodule
