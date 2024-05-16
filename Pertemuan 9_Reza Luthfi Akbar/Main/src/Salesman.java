public class Salesman extends Pegawai{
    private int target;
    private int penjualan;
    public Salesman(String nama, String departemen, char jenisKelamin){
        super(nama, departemen,jenisKelamin);
    }

    public int getTarget() {
        return target;
    }

    public int getPenjualan() {
        return penjualan;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    @Override
    public int thr(){
        if (penjualan >= target){
            return 2 * super.getGaji();
        }
        return super.getGaji();
    }

    @Override
    public String nipPegawai(){
        String nip = super.getNip();
        if (nip != null && nip.startsWith("S")) {
            return nip;
        } else if (getClass() == Salesman.class) {
            return "S000" + super.getUrutanMasuk();
        }
        return "P000" + super.getUrutanMasuk();
    }

    @Override
    public void displayInfo(){
        System.out.println("===============================================");
        System.out.println("Jabatan : Pegawai");
        System.out.println("Nama : " + super.getNama());
        System.out.println("Departemen : " + super.getDepartemen());
        System.out.println("NIP : " + nipPegawai());
        System.out.println("Gaji : " + super.getGaji());
        System.out.println("Gaji : " + thr());
        System.out.println("Cuti : " + super.banyakCuti());
    }

}
