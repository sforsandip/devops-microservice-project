output "vpc_id" {
  description = "VPC ID"
  value       = aws_vpc.main.id
}

output "public_subnet_ids" {
  description = "Public subnet IDs"
  value       = aws_subnet.public[*].id
}

output "private_subnet_ids" {
  description = "Private subnet IDs"
  value       = aws_subnet.private[*].id
}

output "ec2_instance_id" {
  description = "DevOps EC2 instance ID"
  value       = aws_instance.devops.id
}

output "ec2_public_ip" {
  description = "DevOps EC2 public IP"
  value       = aws_instance.devops.public_ip
}

output "ec2_public_dns" {
  description = "DevOps EC2 public DNS"
  value       = aws_instance.devops.public_dns
}

output "eks_cluster_name" {
  description = "EKS cluster name"
  value       = module.eks.cluster_name
}

output "eks_cluster_endpoint" {
  description = "EKS API endpoint"
  value       = module.eks.cluster_endpoint
}