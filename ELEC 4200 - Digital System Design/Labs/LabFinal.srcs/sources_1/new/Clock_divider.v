// fpga4student.com: FPGA projects, VHDL projects, Verilog projects
// Verilog project: Verilog code for clock divider on FPGA
// Top level Verilog code for clock divider on FPGA
module Clock_divider(clockDiv_in,clockDiv_out
    );
input clockDiv_in; // input clock on FPGA
output reg clockDiv_out; // output clock after dividing the input clock by divisor
reg[27:0] counter=28'd0;
parameter DIVISOR = 28'd2;
wire clockOut;
wire lock;
clk_wiz_0 inst2 (.clk_in1(clockDiv_in), .clk_out1(clockOut), .locked(lock));
// The frequency of the output clk_out
//  = The frequency of the input clk_in divided by DIVISOR
// For example: Fclk_in = 50Mhz, if you want to get 1Hz signal to blink LEDs
// You will modify the DIVISOR parameter value to 28'd50.000.000
// Then the frequency of the output clk_out = 50Mhz/50.000.000 = 1Hz
always @(posedge clockDiv_in)
begin
 counter <= counter + 28'd1;
 if(counter>=(DIVISOR-1))
  counter <= 28'd0;
 clockDiv_out <= (counter<DIVISOR/2)?1'b1:1'b0;
end
endmodule