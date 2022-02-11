`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 09:06:30 PM
// Design Name: 
// Module Name: Task3
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


module Task3(
    input d,
    input e, 
    output q, 
    output notQ
    );
   wire q1;
   wire notQ1;
   wire q2;
   wire notQ2;
   
   assign #4 q = ~((~d & e) | notQ);
   assign #4 notQ = ~((d & e) | q);
    
endmodule
