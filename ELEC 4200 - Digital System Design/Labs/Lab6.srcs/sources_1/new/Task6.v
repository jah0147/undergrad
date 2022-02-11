`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 08:36:17 PM
// Design Name: 
// Module Name: Task6
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


module Task6(
    input [3:0] a,
    input [3:0] b,
    input cin,
    output [3:0] s,
    output cout
    );
   
     wire g1, g2, g3, g4, g5, g6,
          g7, g8, g9, g10, g11, g12,
          g13, g14, g15, g16, g17, g18,
          g19, g20, g21, g22, g23, g24, g25;
   
    nor #1 (g2, a[0], b[0]);
    nand #1 (g3, a[0], b[0]);    
    and #3 (g1, ~g2, g3);
    and #3 (g4, ~cin, g3);
    nor #1 (g5, g4, g2); // g5 is the cin for the second bit adder
    xor #4 (s[0], g1, cin);    
   
    nor #1 (g7, a[1], b[1]);
    nand #1 (g8, a[1], b[1]);    
    and #3 (g6, ~g7, g8);
    and #3 (g9, ~cin, g3, g8);
    and #3 (g11, g8, g2);
    nor #1 (g10, g9, g11,g7); // g10 is the cin for the third bit adder
    xor #4 (s[1], g5, g6);
   
    nor #1 (g13, a[2], b[2]);
    nand #1 (g14, a[2], b[2]);        
    and #3 (g12, ~g13, g14);
    and #3 (g15, ~cin, g3, g8, g14);
    and #3 (g17, g8, g14, g2);
    and #3 (g18, g14, g7);
    nor #1 (g16, g15, g17, g18, g13); // g16 is the cin for the fourth bit adder
    xor #4 (s[2], g10, g12);
   
    nor #1 (g20, a[3], b[3]);
    nand #1 (g21, a[3],b[3]);        
    and #3 (g19, ~g20, g21);
    and #3 (g22, ~cin, g3, g8, g14, g21);
    and #3 (g23, g8, g14, g21, g2);
    and #3 (g24, g7, g21, g14);
    and #3 (g25, g21, g13);
    nor #1 (cout, g22, g23, g24, g25, g20);
    xor #4(s[3], g16, g19);
   
endmodule


