module RegisterFile(
input [2:0] RegReadAddr1,
input [2:0] RegReadAddr2,
input [2:0] RegWriteAddr,
input [15:0] RegWriteData,
input RegWrite,//registerWrite enables if 1
output [15:0] RegReadData1,
output [15:0] RegReadData2
);

reg [15:0] REG_FILE [0:7];

assign RegReadData1 = REG_FILE[RegReadAddr1];
assign RegReadData2 = REG_FILE[RegReadAddr2];

initial begin
    REG_FILE[0] = 0;
    REG_FILE[1] = 0;
    REG_FILE[2] = 0;
    REG_FILE[3] = 0;
    REG_FILE[4] = 0;
    REG_FILE[5] = 0;
    REG_FILE[6] = 0;
    REG_FILE[7] = 0;
end
    
    always @ (*) begin
        if (RegWrite) //if RegWrite is enabled
            REG_FILE[RegWriteAddr] = RegWriteData;
           REG_FILE[0] = 0;
    end

endmodule